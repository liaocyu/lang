package 单例模式.枚举;

public class test {
    public static void main(String[] args) {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        System.out.println(s1==s2);
    }
}

enum Singleton{
    INSTANCE;
}
