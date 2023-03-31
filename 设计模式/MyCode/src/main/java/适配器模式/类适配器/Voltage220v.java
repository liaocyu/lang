package 适配器模式.类适配器;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : .java
 * @createTime : 2023/1/10 15:31
 */
// 被适配器模式
public class Voltage220v {
    public int out220V() {
        int src = 220;
        System.out.println("电压是" + src + "伏");
        return src;
    }
}
