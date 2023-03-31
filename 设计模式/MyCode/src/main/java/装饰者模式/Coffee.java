package 装饰者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : Coffee.java
 * @createTime : 2023/1/26 20:19
 */
public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
