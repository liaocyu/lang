package Decoratore;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 21:37
 * @description :
 * 装饰者
 */
public abstract class Decorator extends SchoolReport{
    //首先我要知道是那个成绩单
    private SchoolReport sr;

    // 构造 传递成绩单过来
    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    // 报道成绩单
    public void report() {
        this.sr.report();
    }

    // 让老爹签名
    public void sign(String  name) {
        this.sr.sign(name);
    }

}
