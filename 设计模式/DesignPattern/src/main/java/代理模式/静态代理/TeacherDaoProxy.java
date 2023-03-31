package 代理模式.静态代理;

public class TeacherDaoProxy implements ITeacherDao{
    private ITeacherDao target;//目标对象，通过接口来聚合
    @Override
    public void teach() {
        System.out.println("代理开始");
        target.teach();
        System.out.println("代理结束");
    }

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }
}
