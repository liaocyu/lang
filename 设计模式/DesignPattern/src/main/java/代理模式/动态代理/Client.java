package 代理模式.动态代理;

public class Client {
    public static void main(String[] args) {
        ITeacherDao teacherDao = new TeacherDao();
        ProxyFactory factory = new ProxyFactory(teacherDao);
        ITeacherDao proxyInstance =(ITeacherDao) factory.getProxyInstance();
        proxyInstance.teach();
    }
}
