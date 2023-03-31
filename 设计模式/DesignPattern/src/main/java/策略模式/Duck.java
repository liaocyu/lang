package 策略模式;

public abstract class Duck {
    public abstract void display();
    FlyBehavior flyBehavior;

    public Duck() {
    }

    public void quark(){
        System.out.println("鸭子嘎嘎");
    }

    public void swim(){
        System.out.println("鸭子游泳");
    }

    public void fly(){
        if (flyBehavior!=null){
            flyBehavior.fly();
        }
    }
}
