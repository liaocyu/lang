package 单例模式.懒汉式线程安全同步方法;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton{
    private static Singleton instance;
    private Singleton(){}
    //加入了synchronized关键字实现线程安全
    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
