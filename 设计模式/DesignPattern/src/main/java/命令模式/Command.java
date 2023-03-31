package 命令模式;

//创建命令接口
public interface Command {
    //执行操作
    void execute();
    //撤销操作
    void undo();
}
