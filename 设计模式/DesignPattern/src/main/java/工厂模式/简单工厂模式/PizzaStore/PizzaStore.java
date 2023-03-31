package 工厂模式.简单工厂模式.PizzaStore;

import 工厂模式.简单工厂模式.Factory.SimpleFatory;
import 工厂模式.简单工厂模式.Order.OrderPizza;

public class PizzaStore {
    public static void main(String[] args) {
//        OrderPizza orderPizza = new OrderPizza();
        OrderPizza orderPizza = new OrderPizza(new SimpleFatory());
    }
}
