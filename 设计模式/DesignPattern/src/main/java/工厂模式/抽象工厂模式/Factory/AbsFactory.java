package 工厂模式.抽象工厂模式.Factory;

import 工厂模式.抽象工厂模式.Pizza.Pizza;

public interface AbsFactory {
    //让工厂子类来重写
    Pizza createPizza(String orderType);
}
