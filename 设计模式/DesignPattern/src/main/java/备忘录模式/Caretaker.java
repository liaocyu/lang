package 备忘录模式;

import java.util.List;

public class Caretaker {
    private List<Memento> mementos;

    public void addMemento(Memento memento){
        mementos.add(memento);
    }

    public Memento getMemento(int index){
        return mementos.get(index);
    }
}
