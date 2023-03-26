package zhouyang.locks.fairOrUnFairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/18 1:33
 * @description : 演示 可重入锁的死锁
 */
public class ReEnterLockDemo3 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {

            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t -------come in外层调用");
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName() + "\t --------come in 内层调用");
                }finally {
                    lock.unlock();
                }

                int i = 10 /0;
            }catch(Exception e) {
                System.out.println("所以说进入异常可能会导致死锁的情况的");
                // lock.unlock(); // 当少了一个 unlock的情况下会出现死锁的问题
            }
        }, "t1").start();
         // 加入上面的 t1线程一直没有释放 lock锁 下面的 t2线程会一直等到t1线程释放lock锁
        new Thread(() -> {

            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "\t -------come in外层调用");
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName() + "\t -------- come in 内层调用");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        }, "t2").start();
    }

}
