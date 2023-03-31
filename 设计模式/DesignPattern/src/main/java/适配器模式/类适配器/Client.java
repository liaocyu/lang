package 适配器模式.类适配器;

public class Client {

    public static void main(String[] args) {
        //类适配器
        Phone phone = new Phone();
        phone.charge(new VoltageAdapter());
    }
}
