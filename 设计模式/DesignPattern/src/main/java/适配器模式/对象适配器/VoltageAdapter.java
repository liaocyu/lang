package 适配器模式.对象适配器;

import java.io.*;

//适配器
public class VoltageAdapter implements Voltage5V{
    private Voltage220V v;
    @Override
    public int output5V() {
        if(v!=null){
            //获取到220v的电压
            int srcV = v.output220V();
            System.out.println("电压变成5v");
            return srcV/44; //转成5v
        }else {
            throw new RuntimeException("你怎么不给我插电呢");
        }

    }

    public VoltageAdapter(Voltage220V v) {
        this.v = v;
    }
}
