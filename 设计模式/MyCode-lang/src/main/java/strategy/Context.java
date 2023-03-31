package strategy;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 16:29
 * @description :
 */
public class Context {

    private IStrategy strategy;

    public Context(IStrategy iStrategy) {
        this.strategy = iStrategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}
