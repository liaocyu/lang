package 适配器模式.类适配器;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : .java
 * @createTime : 2023/1/10 15:42
 */
public class client {
    public static void main(String[] args) {
        phone phone = new phone();
        phone.charge(new VoltageAdapter());
    }
}
