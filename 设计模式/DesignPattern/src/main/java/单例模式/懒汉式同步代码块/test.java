package 单例模式.懒汉式同步代码块;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton{
    private static Singleton instance;
    private Singleton(){}
    //加入了synchronized关键字实现线程安全
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
