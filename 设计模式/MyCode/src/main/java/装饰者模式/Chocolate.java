package 装饰者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : chocolate.java
 * @createTime : 2023/1/26 20:17
 */
public class Chocolate extends Decorator{

    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f);
    }
}
