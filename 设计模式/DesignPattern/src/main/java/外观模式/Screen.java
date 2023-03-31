package 外观模式;

public class Screen {
    private Screen(){}
    private static final Screen INSTANCE = new Screen();

    public static Screen getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println("Screen on");
    }

    public void off(){
        System.out.println("Screen off");
    }

    public void pause(){
        System.out.println("Screen pause");
    }

    public void show(){
        System.out.println("Screen show");
    }
}
