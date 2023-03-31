package 中介者模式;

import java.util.HashMap;

public class ConcreteMediator implements Mediator{
    private HashMap<String,Colleague> colleagueMap;


    @Override
    public void getMessage(int stateChange, String name) {
        //这里按照不同的stateChange和不同的name来判断接下来该做什么
    }

    @Override
    public void register(String name, Colleague colleague) {
        colleagueMap.put(name,colleague);
    }

    @Override
    public void sendMessage() {

    }


}
