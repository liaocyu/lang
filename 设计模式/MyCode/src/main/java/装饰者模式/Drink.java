package 装饰者模式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : MyCode
 * @ClassName : Drink.java
 * @createTime : 2023/1/26 20:05
 */
public abstract class Drink {

    public String des;// 描述
    private float price = 0.0f;
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public abstract float cost();
}
