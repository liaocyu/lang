package 外观模式;

public class DVDPlayer {
    private DVDPlayer(){}
    private static final DVDPlayer INSTANCE = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return INSTANCE;
    }

    public void on(){
        System.out.println("dvd on");
    }

    public void off(){
        System.out.println("dvd off");
    }

    public void pause(){
        System.out.println("dvd pause");
    }

    public void play(){
        System.out.println("dvd play");
    }
}
