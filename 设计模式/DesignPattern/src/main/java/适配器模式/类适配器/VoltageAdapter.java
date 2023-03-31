package 适配器模式.类适配器;

//适配器
public class VoltageAdapter extends Voltage220V implements Voltage5V {
    @Override
    public int output5V() {
        //获取到220v的电压
        int srcV = output220V();
        return srcV/44; //转成5v
    }
}
