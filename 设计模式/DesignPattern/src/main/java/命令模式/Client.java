package 命令模式;

public class Client {
    public static void main(String[] args) {
        //创建电灯对象
        LightReceiver light = new LightReceiver();
        //创建电灯命令对象
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        //执行遥控器按钮添加命令
        RemoteController remoteController = new RemoteController();
        remoteController.setCommand(0,lightOnCommand,lightOffCommand);
        //按按钮执行命令
        remoteController.onButton(0);
        remoteController.offButton(0);
        remoteController.undo();
    }
}
