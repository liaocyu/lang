package strategy;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 16:27
 * @description :
 */
public class GiveGreenLight implements IStrategy{
    @Override
    public void operate() {
        System.out.println("求乔国老帮忙 开门放人");
    }
}
