package 桥接模式;

public class FoldPhone extends Phone{
    public FoldPhone(Brand brand) {
        super(brand); // 调用父类 phone 这个有参构造方法
    }

    public void open(){
        System.out.println("弯手机");
        super.open();
    }

    public void close(){
        System.out.println("弯手机");
        super.close();
    }
    public void call(){
        System.out.println("弯手机");
        super.call();
    }
}
