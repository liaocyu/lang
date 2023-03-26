package zhouyang.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/21 22:23
 * @description : 先交代一下程序: 静态成员变量x就是要操作的资源。 静态方法incr()就是对x进行加1操作。
 * 在main方法中定义CountDownLatch对象，用来确保所有线程结束之后再输出x的结果。 循环创建 100个线程 每个线程调用 incr() 方法 1000次
 * 理论上x最终的值应该使 100000
 */
public class Test {
    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        // 定义 CountDownLatch 确保所有线程结束之后 在输出x的值
        CountDownLatch cd = new CountDownLatch(100);
        // 循环创建 100个线程
        for (int i = 0; i < 100 ; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    incr();
                }
                cd.countDown();
            }, "t1").start();
        }
        // 确保 所有线程结束之后再继续执行
        cd.await();
        // 输出x的值
        System.out.println(x);
    }

    private static void incr() {

        x++;
    }
}
