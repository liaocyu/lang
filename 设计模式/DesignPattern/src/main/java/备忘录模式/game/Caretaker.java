package 备忘录模式.game;

import java.util.List;
import java.util.Map;

public class Caretaker {
    private Memento memento;
//    对一个角色保存多个状态
//    private List<Memento> mementos;
//    对多个角色保存多个状态
//    private Map<String,List<Memento>> map;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
