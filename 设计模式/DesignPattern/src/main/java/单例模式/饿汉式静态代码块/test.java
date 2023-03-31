package 单例模式.饿汉式静态代码块;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton{
    //1.构造器私有化
    private Singleton(){}
    //2，本类内部创建对象实例
    private static final Singleton instance;
    static {//在静态代码块中创建实例对象
        instance = new Singleton();
    }
    //3.提供公有静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
