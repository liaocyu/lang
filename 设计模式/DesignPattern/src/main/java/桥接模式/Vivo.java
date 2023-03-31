package 桥接模式;

public class Vivo implements Brand{
    @Override
    public void call() {
        System.out.println("Vivo打电话");
    }

    @Override
    public void close() {
        System.out.println("Vivo打关机");
    }

    @Override
    public void open() {
        System.out.println("Vivo打开机");
    }
}
