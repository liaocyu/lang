package 装饰者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : Decorator.java
 * @createTime : 2023/1/26 20:10
 */
public class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        // getPrice 自己的价格
        return super.getPrice() + obj.cost();
    }

    public String getDesc() {
        return des + " " + getPrice() + " && " + obj.getDes();
    }
}
