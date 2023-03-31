package 外观模式;

public class HomeController {
    private DVDPlayer dvdPlayer;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;

    public HomeController(){
        dvdPlayer = DVDPlayer.getInstance();
        popcorn = Popcorn.getInstance();
        projector = Projector.getInstance();
        screen = Screen.getInstance();
    }

    public void ready(){
        popcorn.on();
        popcorn.pop();
        projector.on();
        projector.focus();
        screen.show();
    }

    public void pause(){
        dvdPlayer.pause();
    }

    public void start(){
        dvdPlayer.play();
    }

    public void stop(){
        popcorn.off();
        projector.off();
        screen.off();
        dvdPlayer.off();
    }
}
