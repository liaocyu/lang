package zhouyang.locks.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 0:25
 * @description : 演示 volatile 、 AtomicBoolean 、 Thread 中的API 来实现中断线程
 */
public class InterruptDemo {

    static volatile  boolean isStop = false;

    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {

       // m1_volatile();

       // m2_atomicBoolean();

        m3_thread_api();



    }

    private static void m3_thread_api() {

        Thread t1 = new Thread(() -> {

            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t isInterrupted()被修改为true 程序停止");
                    break;
                }

                System.out.println("---------------------hello interrupt");
            }

        }, "t1");
        t1.start();
        try { TimeUnit.MILLISECONDS.sleep(1); } catch (InterruptedException e ) { e.printStackTrace() ; }


        // 演示 t1 自己中断

        t1.interrupt();
/*        new Thread(() -> {
            t1.interrupt();
        }, "t2").start();*/

    }

    private static void m2_atomicBoolean() {
        new Thread(() -> {

            while(true) {
                if(atomicBoolean.get()) {
                    System.out.println(Thread.currentThread().getName() + "\t  使用 atomicBoolean 关键字可以监测其他线程修改了资源");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "\t atomicBoolean 并没有停止的意思");
            }

        }, "t1").start();

        try { TimeUnit.MILLISECONDS.sleep(1); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> atomicBoolean.set(true), "t2").start();
    }

    private static void m1_volatile() {
        new Thread(() -> {

            while(true) {
                if(isStop) {
                    System.out.println(Thread.currentThread().getName() + "\t  使用volatile关键字可以看见其他线程修改了资源");
                    break;
                }

                System.out.println(Thread.currentThread().getName() + "\t isStop并没有停止的意思");
            }

        }, "t2").start();

        try { TimeUnit.MILLISECONDS.sleep(1); } catch (InterruptedException e ) { e.printStackTrace() ; }


        new Thread(() -> isStop = true, "t1").start();
    }
}
