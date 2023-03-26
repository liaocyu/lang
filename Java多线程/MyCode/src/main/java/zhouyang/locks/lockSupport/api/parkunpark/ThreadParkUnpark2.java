package zhouyang.locks.lockSupport.api.parkunpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 14:30
 * @description : 使用 LockSupport.park() 和LockSupport.unpark()可以实现先唤醒后等待 不会出现异常 你掌握了原理就幸苦了 主要还是看permit
 */
public class ThreadParkUnpark2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }
            System.out.println(Thread.currentThread().getName() + "\t" + "我进来了 完成我自己的业务代码");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "我被大哥唤醒了 ");
        }, "t1");

        t1.start();

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        new Thread(() -> {
            LockSupport.unpark(t1);

            System.out.println(Thread.currentThread().getName() + "\t" + "我成功唤醒了 t1");

        }, "t2").start();

    }
}
