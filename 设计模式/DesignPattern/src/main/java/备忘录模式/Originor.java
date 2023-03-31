package 备忘录模式;

public class Originor {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateMemento(){
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
