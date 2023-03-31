package Decoratore;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 21:32
 * @description : 成绩单的抽象类 然后有一个四年级的成绩单的实现类
 *
 * 抽象方法只能存在于抽象类中
 */
public abstract class SchoolReport {

    // 报道成绩
    public abstract void report();

    // 签字
    public abstract void sign(String name);
}
