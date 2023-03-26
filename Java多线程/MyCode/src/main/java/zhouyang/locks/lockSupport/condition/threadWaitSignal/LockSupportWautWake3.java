package zhouyang.locks.lockSupport.condition.threadWaitSignal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 13:40
 * @description : 先signal后await会报异常
 */
public class LockSupportWautWake3 {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        new Thread(() -> {

            lock.lock();

            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "---------------发出通知");
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> {

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
