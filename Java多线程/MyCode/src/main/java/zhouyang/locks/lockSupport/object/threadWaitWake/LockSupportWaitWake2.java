package zhouyang.locks.lockSupport.object.threadWaitWake;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 11:31
 * @description : 当线程等待唤醒的代码块中不加 同步的关键字时 先执行 notify 在执行wait会报异常结束
 */
public class LockSupportWaitWake2 {

    public static void main(String[] args) {
        Object objectLock = new Object();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 有线程进入了 可以处理资源");

            // 加锁
            try {
                System.out.println("线程被加锁了 等待 object类的 notify方法释放锁");
                objectLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "t1").start();


        try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {

            System.out.println("我来释放锁");

            objectLock.notify();
        }, "t2").start();

    }
}
