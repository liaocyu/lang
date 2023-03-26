package zhouyang.volatite;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 21:24
 * @description : 演示Volatile这个关键字的特性 ： 保证可见性
 *  加了 volatile关键字 可以保证其他线程的可见性
 */
public class VolatileSeeDemo {

     static volatile boolean flag = true;

    // static  boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

            while(flag) {
                new Integer(308);
            }
            System.out.println("t1 over");
        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> flag = false, "t2").start();
    }
}
