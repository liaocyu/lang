package 工厂模式.抽象工厂模式.Pizza;

public class LDCheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println(name+"正在准备");
    }
}
