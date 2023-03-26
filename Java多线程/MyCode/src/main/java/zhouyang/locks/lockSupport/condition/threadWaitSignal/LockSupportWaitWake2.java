package zhouyang.locks.lockSupport.condition.threadWaitSignal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 13:36
 * @description : lock、unlock对里面才能正确调用condition中线程等待和唤醒的方法 就想成里面 sychronized 的作用
 */

public class LockSupportWaitWake2 {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args)//main 方法，主线程一切程序入口
    {

        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        // 暂停几秒钟线程 
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }


}
