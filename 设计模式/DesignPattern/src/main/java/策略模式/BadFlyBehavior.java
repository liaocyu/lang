package 策略模式;

public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("飞的贼慢");
    }
}
