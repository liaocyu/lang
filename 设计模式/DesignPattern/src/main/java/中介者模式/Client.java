package 中介者模式;

public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        //Alarm和CoffeeMachine都是Colleague的子类，创建时构造方法会自动将该对象放到mediator的map中
        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        //在这里执行调用方法
        alarm.sendMessage(0);
        coffeeMachine.sendMessage(1);
    }
}
