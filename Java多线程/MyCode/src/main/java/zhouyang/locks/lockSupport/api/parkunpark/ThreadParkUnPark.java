package zhouyang.locks.lockSupport.api.parkunpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 14:22
 * @description : 使用 LockSupport里面的 park() 来阻塞线程 、使用 LockSupport的 unpark(thread) 来唤醒线程
 */
public class ThreadParkUnPark {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t" + "----come in");
            // 线程阻塞
            LockSupport.park();

            System.out.println(Thread.currentThread().getName() + "\t" + "-----当前线程被唤醒了 ");


        }, "t1");

        t1.start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {
            // 唤醒线程
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + " 我已经成功唤醒了阻塞的线程了 ");

        }, "t2").start();
    }
}
