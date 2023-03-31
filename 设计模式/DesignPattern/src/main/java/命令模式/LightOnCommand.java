package 命令模式;

public class LightOnCommand implements Command{
    private LightReceiver light;

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }
}
