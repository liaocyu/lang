package 策略模式;

public class ToyDuck extends Duck{
    public ToyDuck() {
        this.flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {

    }
}
