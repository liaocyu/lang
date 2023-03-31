package 适配器模式.类适配器;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : .java
 * @createTime : 2023/1/10 15:36
 */
public class VoltageAdapter extends Voltage220v implements IVoltage5V{
    /**
     * 将220V的电压转为5V的电压
     * @return
     */
    @Override
    public int out5V() {

        int srcV = out220V();
        return srcV / 44;
    }
}
