package 备忘录模式.game;

public class Client {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Caretaker caretaker = new Caretaker();
        monster.setAttack(100);
        monster.setDefence(100);
        System.out.println(monster);
        Memento monsterMemento = monster.getMonsterMemento();
        caretaker.setMemento(monsterMemento);
        monster.setDefence(200);
        monster.setAttack(200);
        System.out.println(monster);
        monster.getLastCondition(caretaker.getMemento());
        System.out.println(monster);
    }
}
