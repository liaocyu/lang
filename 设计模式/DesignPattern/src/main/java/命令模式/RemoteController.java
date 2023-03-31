package 命令模式;

public class RemoteController {
    //按钮命令的数组
    Command[] onCommands;
    Command[] offCommands;

    //执行撤销的命令
    Command undoCommand = new NoCommand();

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i=0;i<5;i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给按钮设置命令
    public void setCommand(int no,Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开的按钮
    public void onButton(int no){
        Command onCommand = onCommands[no];
        onCommand.execute();
        undoCommand = onCommand;
    }

    //按下关的按钮
    public void offButton(int no){
        Command offCommand = offCommands[no];
        offCommand.execute();
        undoCommand = offCommand;
    }

    public void undo(){
        undoCommand.undo();
        undoCommand = new NoCommand();
    }
}
