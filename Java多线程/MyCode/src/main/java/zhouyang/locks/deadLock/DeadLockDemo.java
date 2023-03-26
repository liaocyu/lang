package zhouyang.locks.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/18 11:43
 * @description : 演示死锁现象
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        final Object objectA = new Object();

        final Object objectb = new Object();

        new Thread(() -> {
            // 锁住 objectA
            synchronized( objectA ) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有A锁 ，希望获得B锁");
                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }
                synchronized(objectb) {
                    System.out.println(Thread.currentThread().getName() + "\t 来到这里证明获取B锁成功");
                }
            }
        }, "A").start();

        new Thread(() -> {

            // 锁住B
            synchronized( objectb ) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有B锁 ，希望获得A锁");
                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }
                synchronized(objectA) {
                    System.out.println(Thread.currentThread().getName() + "\t 来到这里证明获取A锁成功");
                }
            }
        }, "B").start();



    }
}
