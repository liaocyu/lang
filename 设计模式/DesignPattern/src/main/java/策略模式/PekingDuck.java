package 策略模式;

public class PekingDuck extends Duck{
    public PekingDuck() {
        this.flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {

    }
}
