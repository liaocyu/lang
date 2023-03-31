package 适配器模式.类适配器;

//被适配者
public class Voltage220V {
    public int output220V(){
        int src = 220;
        System.out.println("电压是"+src);
        return src;
    }
}
