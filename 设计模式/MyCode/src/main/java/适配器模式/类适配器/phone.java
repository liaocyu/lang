package 适配器模式.类适配器;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : .java
 * @createTime : 2023/1/10 15:39
 */
public class phone {
    // 充电
    public void charge(IVoltage5V v) {
        if(v.out5V() == 5) {
            System.out.println("电压现在是5V , 可以充电");
        }else if(v.out5V() > 5){
            System.out.println("电压现在大于5伏 , 手机会被击穿");
        }
    }
}
