package strategy;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 16:30
 * @description : 设计模式-------策略模式
 * 优点 ： 可以在运行时动态的改变对象的行为 同时谜面了使用大量的条件语句
 * 缺点 ： 需要定义大量的策略类 增加了系统的复杂度 如果策略过多 还可能导致程序运行时的性能下降
 */
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;

        System.out.println("-------------拆第一个锦囊-------------");
        context = new Context(new BackDoor());
        context.operate();
        System.out.println("-------------出招完毕-----------------");
        System.out.println("\n\n");

        System.out.println("-------------拆第二个锦囊-------------");
        context = new Context(new GiveGreenLight());
        context.operate();
        System.out.println("-------------出招完毕-----------------");
        System.out.println("\n\n");

        System.out.println("-------------拆第三个锦囊-------------");
        context = new Context(new BlockEnem());
        context.operate();
        System.out.println("-------------出招完毕-----------------");

    }
}
