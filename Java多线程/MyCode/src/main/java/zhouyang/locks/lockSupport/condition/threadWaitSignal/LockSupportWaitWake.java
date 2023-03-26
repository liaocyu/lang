package zhouyang.locks.lockSupport.condition.threadWaitSignal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 11:49
 * @description : 使用 Condition接口中的 wait和 signal方法实现线程等待和唤醒
 */
public class LockSupportWaitWake {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

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
        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {

            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            } finally {
                lock.unlock();
            }

        }, "t2").start();
    }
}
