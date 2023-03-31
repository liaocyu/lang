package 装饰者模式;

// 具体的 Decorator 这里就是调味品

public class Chocolate extends Decorator{

    public Chocolate(Drink drink) {
        super(drink);
        setDescription("Chocolate");
        setPrice(3d);
    }

    public Chocolate() {
    }
}
