package 工厂模式.简单工厂模式.PizzaStore;

public class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备CheesePizza的材料");
    }
}
