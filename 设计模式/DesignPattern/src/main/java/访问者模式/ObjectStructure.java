package 访问者模式;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {
    private List<Person> people = new LinkedList<>();

    public void attach(Person p){
        people.add(p);
    }

    public void detach(Person p){
        people.remove(p);
    }

    public void display(Action action){
        for(Person person:people){
            person.accept(action);
        }
    }
}
