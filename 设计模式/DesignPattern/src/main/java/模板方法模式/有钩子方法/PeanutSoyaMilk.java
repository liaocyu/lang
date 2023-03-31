package 模板方法模式.有钩子方法;

public class PeanutSoyaMilk extends SoyaMilk {
    @Override
    public void add() {
        System.out.println("加花生");
    }
}
