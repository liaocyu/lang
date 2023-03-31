package 适配器模式.对象适配器;

public class Client {
    /**
     * 对象适配器和类适配器是同一种思想 其中 使用组合替代继承 解决了类适配必须继承src的局限性问题
     *
     * @param args
     */
    public static void main(String[] args) {
        //对象适配器
        Phone phone = new Phone();
        phone.charge(new VoltageAdapter(new Voltage220V()));
    }
}
