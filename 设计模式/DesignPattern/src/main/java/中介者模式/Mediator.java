package 中介者模式;

import 迭代器模式.College;

public interface Mediator {
    void getMessage(int stateChange,String name);
    void register(String name, Colleague colleague);
    void sendMessage();
}
