package 中介者模式;

public class Alarm extends Colleague{
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name,this);
    }

    @Override
    public void sendMessage(int stateChange) {
        //获取到mediator来执行对应操作
        getMediator().getMessage(stateChange,this.getName());
    }
}
