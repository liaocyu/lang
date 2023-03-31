package 装饰者模式;

public class Coffee extends Drink{
    @Override
    public double cost() {
        return super.getPrice();
    }
}
