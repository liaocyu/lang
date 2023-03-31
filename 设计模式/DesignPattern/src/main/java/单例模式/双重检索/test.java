package 单例模式.双重检索;

public class test {
    public static void main(String[] args) {

    }
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    //加入了双重检查代码，解决了线程安全问题，同时解决了懒加载问题
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
