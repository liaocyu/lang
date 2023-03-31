package 适配器模式.接口适配器;

public class Client {
    public static void main(String[] args) {
        Abstract anAbstract = new Abstract() {
            @Override
            public void m1() {
                System.out.println("m1");
            }
        };

        anAbstract.m1();
    }
}
