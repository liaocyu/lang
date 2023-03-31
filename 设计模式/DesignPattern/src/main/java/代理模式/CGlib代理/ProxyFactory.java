package 代理模式.CGlib代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import 代理模式.动态代理.TeacherDao;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private TeacherDao target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib代理开始");
        Object returnObj = method.invoke(target, objects);
        System.out.println("CGlib代理结束");
        return returnObj;
    }

    public Object getProxyInstance(){
        //1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象，即代理对象
        return enhancer.create();
    }

    public ProxyFactory(TeacherDao target) {
        this.target = target;
    }
}
