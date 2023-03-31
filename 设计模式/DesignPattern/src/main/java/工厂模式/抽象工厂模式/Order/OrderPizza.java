package 工厂模式.抽象工厂模式.Order;

import 工厂模式.抽象工厂模式.Factory.AbsFactory;
import 工厂模式.抽象工厂模式.Pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {
    private AbsFactory factory;

    public void setFactory(AbsFactory factory) {
        this.factory = factory;
        Pizza pizza;
        String orderType;
        do {
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if(pizza==null){
                System.out.println("不存在该品种");
                break;
            }else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        }while (true);
    }

    public OrderPizza(){}
    public OrderPizza(AbsFactory factory){
        this.setFactory(factory);
    }
    private String getType(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入披萨类型");
            return br.readLine();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
