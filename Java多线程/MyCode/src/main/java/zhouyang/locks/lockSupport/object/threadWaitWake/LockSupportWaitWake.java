package zhouyang.locks.lockSupport.object.threadWaitWake;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 11:13
 * @description : Object 类中的 wait和 notify方法实现线程等待和唤醒
 */
public class LockSupportWaitWake {
    // main 主线程一切程序的入口守护线程
    public static void main(String[] args) {


        Object objectLock = new Object();

        //
        new Thread(() -> {
            // 锁着统一资源
            synchronized(objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t --------有线程拿到资源了");

                try {
                    // 使用Object类的wait来是使线程等待
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"\t"+"---发出通知 解锁了 ");
            }
        }, "t2").start();

    }
}
