package zhouyang.locks.interrupt;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 2:04
 * @description :
 */
public class InterruptDemo4 {
    // 测试当前线程是否被中断（检查中断标志）  返回一个boolean并清除中断状态
    // 第二次在调用时中断状态已经被清楚过 将返回一个 false

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println("------1");
        Thread.currentThread().interrupt();
        System.out.println("------2");
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());

        Thread.currentThread().interrupt();


        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.interrupted());


    }
}
