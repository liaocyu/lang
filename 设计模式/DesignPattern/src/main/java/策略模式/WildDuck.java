package 策略模式;

public class WildDuck extends Duck{
    public WildDuck() {
        this.flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {

    }
}
