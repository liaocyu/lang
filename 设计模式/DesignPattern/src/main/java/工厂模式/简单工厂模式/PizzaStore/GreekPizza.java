package 工厂模式.简单工厂模式.PizzaStore;

public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备GreekPizza的材料");
    }

}
