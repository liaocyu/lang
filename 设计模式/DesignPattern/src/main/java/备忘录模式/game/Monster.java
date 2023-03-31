package 备忘录模式.game;

public class Monster {
    private Integer attack;
    private Integer defence;

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Memento getMonsterMemento(){
        return new Memento(attack,defence);
    }

    public void getLastCondition(Memento memento){
        this.attack = memento.getAttack();
        this.defence = memento.getDefence();
    }

    @Override
    public String toString() {
        return "Monster{" +
                "attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}
