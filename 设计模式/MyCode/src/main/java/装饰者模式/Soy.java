package 装饰者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : .java
 * @createTime : 2023/1/26 20:37
 */
public class Soy extends Decorator{
    public Soy(Drink obj) {
        super(obj);

        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
