package 工厂模式.抽象工厂模式.Pizza;

import 工厂模式.抽象工厂模式.Factory.BJFactory;
import 工厂模式.抽象工厂模式.Order.OrderPizza;

public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza(new BJFactory());
    }
}
