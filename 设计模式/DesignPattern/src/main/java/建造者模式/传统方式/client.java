package 建造者模式.传统方式;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : create by lcy
 * @version : 1.0
 * @Project : DesignPattern
 * @ClassName : .java
 * @createTime : 2023/1/9 19:31
 */
public class client {
    public static void main(String[] args) {
        CommonBuilding commonBuilding = new CommonBuilding();
        commonBuilding.build();
    }
}
