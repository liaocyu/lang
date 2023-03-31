package 单例模式.静态内部类;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton{
    //构造器私有化
    private Singleton(){}
    //静态内部类
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }
    //公有静态方法
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
