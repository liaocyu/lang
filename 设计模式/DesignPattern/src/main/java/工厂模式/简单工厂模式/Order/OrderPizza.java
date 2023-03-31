package 工厂模式.简单工厂模式.Order;

import 工厂模式.简单工厂模式.Factory.SimpleFatory;
import 工厂模式.简单工厂模式.PizzaStore.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType;
//        do{
//            orderType = getType();
//            if("greek".equals(orderType)){
//                pizza = new GreekPizza();
//                pizza.setName("greek");
//            } else if ("cheese".equals(orderType)) {
//                pizza = new CheesePizza();
//                pizza.setName("cheese");
//            }else {
//                break;
//            }
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//        }while (true);
//    }
    Pizza pizza;
    SimpleFatory simpleFatory;
    public OrderPizza(SimpleFatory simpleFatory){
        this.setSimpleFatory(simpleFatory);
    }

    public void setSimpleFatory(SimpleFatory simpleFatory) {
        this.simpleFatory = simpleFatory;
        do{
            String orderType = getType();
            pizza = simpleFatory.getPizza(orderType);
            if(pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("披萨不存在");
                break;
            }
        }while (true);

    }

    public OrderPizza(){}
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
