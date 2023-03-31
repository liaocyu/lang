package 访问者模式;

public class Success extends Action{
    @Override
    public void getManResult(Man man) {
        System.out.println("男人觉得好");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人觉得好");
    }
}
