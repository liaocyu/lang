package 装饰者模式;

public class Milk extends Decorator{
    public Milk() {
        setDescription("Milk");
        setPrice(2d);
    }

    public Milk(Drink drink) {
        setDrink(drink);
        setDescription("Milk");
        setPrice(2d);
    }
}
