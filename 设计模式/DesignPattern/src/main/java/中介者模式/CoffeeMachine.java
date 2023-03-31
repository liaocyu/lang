package 中介者模式;

public class CoffeeMachine extends Colleague{
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    @Override
    public void sendMessage(int stateChange) {
        getMediator().getMessage(stateChange,this.getName());
    }
}
