package 代理模式.动态代理;

public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("JDK动态代理teach");
    }
}
