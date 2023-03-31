package 单例模式.懒汉式线程不安全;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton{
    private static Singleton instance;

    private Singleton(){}
    //提供一个静态的公有方法，当使用该方法时才去创建instance
    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
