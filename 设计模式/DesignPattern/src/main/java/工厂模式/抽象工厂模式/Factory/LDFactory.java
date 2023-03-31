package 工厂模式.抽象工厂模式.Factory;

import 工厂模式.抽象工厂模式.Pizza.*;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if("cheese".equals(orderType)){
            pizza = new LDCheesePizza();
            pizza.setName("伦敦奶酪披萨");
        }else if ("greek".equals(orderType)){
            pizza = new LDGreekPizza();
            pizza.setName("伦敦希腊披萨");
        }
        return pizza;
    }
}
