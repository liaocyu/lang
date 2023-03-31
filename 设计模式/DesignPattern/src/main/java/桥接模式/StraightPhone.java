package 桥接模式;

public class StraightPhone extends Phone{

    public StraightPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        System.out.println("直手机");
        super.open();
    }

    public void close(){
        System.out.println("直手机");
        super.close();
    }
    public void call(){
        System.out.println("直手机");
        super.call();
    }
}
