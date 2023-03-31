package 命令模式;

public class LightOffCommand implements Command{
    private LightReceiver light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }
}
