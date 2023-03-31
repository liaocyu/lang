package 模板方法模式.有钩子方法;

public class PureSoyaMilk extends SoyaMilk{
    @Override
    public void add() {
        //空实现即可
    }

    @Override
    public boolean wantCondiment() {
        return false;
    }
}
