package 备忘录模式.game;

public class Memento {
    private Integer attack;
    private Integer defence;

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public Memento(Integer attack, Integer defence) {
        this.attack = attack;
        this.defence = defence;
    }
}
