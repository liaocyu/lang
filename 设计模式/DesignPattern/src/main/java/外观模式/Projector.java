package 外观模式;

public class Projector {
    private Projector(){}
    private static final Projector INSTANCE = new Projector();

    public static Projector getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println("Projector on");
    }

    public void off(){
        System.out.println("Projector off");
    }

    public void pause(){
        System.out.println("Projector pause");
    }

    public void focus(){
        System.out.println("Projector focus");
    }
}
