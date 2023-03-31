package 桥接模式;

public abstract class Phone{
    // 聚合品牌
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public Phone() {
    }

    protected void open(){
        this.brand.open();
    }

    protected void close(){
        this.brand.close();
    }

    protected void call(){
        this.brand.call();
    }

}
