package 策略模式;

public class NoFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("压根不会飞");
    }
}
