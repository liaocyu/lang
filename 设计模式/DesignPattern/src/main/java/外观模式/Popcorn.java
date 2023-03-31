package 外观模式;

public class Popcorn {
    private Popcorn(){}
    private static final Popcorn INSTANCE = new Popcorn();

    public static Popcorn getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println("Popcorn on");
    }

    public void off(){
        System.out.println("Popcorn off");
    }

    public void pause(){
        System.out.println("Popcorn pause");
    }

    public void pop(){
        System.out.println("Popcorn pop");
    }
}
