package 工厂模式.简单工厂模式.Factory;

import 工厂模式.简单工厂模式.PizzaStore.CheesePizza;
import 工厂模式.简单工厂模式.PizzaStore.GreekPizza;
import 工厂模式.简单工厂模式.PizzaStore.Pizza;

import java.util.Calendar;

public class SimpleFatory {
    public Pizza getPizza(String orderType) {
        Pizza pizza = null;
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        }
        return pizza;
    }

}
