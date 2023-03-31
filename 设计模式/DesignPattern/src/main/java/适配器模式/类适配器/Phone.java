package 适配器模式.类适配器;

public class Phone {
    //充电
    public void charge(Voltage5V v){
        if(v.output5V()==5){
            System.out.println("可以充电");
        }else {
            System.out.println("我要被冲爆掉了");
        }
    }
}
