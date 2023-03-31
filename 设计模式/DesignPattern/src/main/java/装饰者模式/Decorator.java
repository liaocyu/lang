package 装饰者模式;

//

public class Decorator extends Drink{
    private Drink drink;
    @Override
    public double cost() {
        return super.getPrice()+drink.cost();
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    public Decorator() {

    }

    @Override
    public String getDescription() {
        return super.getDescription()+" && "+drink.getDescription();
    }
}
