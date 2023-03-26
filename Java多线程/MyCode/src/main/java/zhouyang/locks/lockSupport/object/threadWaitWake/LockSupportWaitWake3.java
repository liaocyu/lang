package zhouyang.locks.lockSupport.object.threadWaitWake;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 11:41
 * @description : 演示异常 当 Object类的 notify 放在 wait之前也会出现异常 程序无法执行
 */
public class LockSupportWaitWake3 {

    public static void main(String[] args) {


        Object objectLock = new Object();
        // 加锁 锁住同一个资源
        new Thread(() -> {

            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

                //先 notify在wait导致程序无法执行
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            }

        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> {

            synchronized (objectLock) {
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " \t " + " 被唤醒了 ");

        }, "t2").start();
    }
}
