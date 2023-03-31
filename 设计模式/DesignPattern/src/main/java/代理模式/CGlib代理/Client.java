package 代理模式.CGlib代理;

import 代理模式.动态代理.TeacherDao;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new TeacherDao());
        TeacherDao proxyInstance =(TeacherDao) factory.getProxyInstance();
        proxyInstance.teach();
    }

}

