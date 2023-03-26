package zhouyang.locks.lockSupport.api.parkunpark;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 14:35
 * @description : 嗲用LockSupport.unpark()会使permit加1  但是permit的上线只能为1 因此线程会陷入阻塞
 */
public class ThreadParkUnpark3 {

    public static void main(String[] args)//main 方法，主线程一切程序入口
    {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "---被唤醒");
        }, "t1");
        t1.start();

        new Thread(() -> {
            LockSupport.unpark(t1);

            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName() + "\t" + "---发出通知");
        }, "t2").start();
    }
}