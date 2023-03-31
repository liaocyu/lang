package 工厂模式.抽象工厂模式.Factory;

import 工厂模式.抽象工厂模式.Pizza.BJCheesePizza;
import 工厂模式.抽象工厂模式.Pizza.BJGreekPizza;
import 工厂模式.抽象工厂模式.Pizza.Pizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equals(orderType)){
            pizza = new BJCheesePizza();
            pizza.setName("北京奶酪披萨");
        }else if ("greek".equals(orderType)){
            pizza = new BJGreekPizza();
            pizza.setName("北京希腊披萨");
        }
        return pizza;
    }
}
