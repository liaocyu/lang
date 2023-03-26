package zhouyang.locks.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 0:25
 * @description : 如果当前线程处于不活跃状态 就类似于本列中的 for循环完成之后 就是不活跃状态 此时 isinterrupt就是false
 */
public class InterruptDemo2 {

    public static void main(String[] args) {
        // 实列方法interrupt（） 仅仅是设置线程的中断状态为true 不会停止线程 27行  然后进入线程进入循环  因为在打印的时候 也浪费了2毫秒与30行相对应 于是打印了第30行
        // 至此 打印完所有的 此时因为睡眠2秒钟 37行没有执行 于是打印完执行了23行  等到睡眠了2秒钟  就执行了 37行
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 300; i++) {

                System.out.println("-----:" + i);
            }
            System.out.println("t1线程调用interrupt()后的的中断标识02：" + Thread.currentThread().isInterrupted());

        }, "t1");
        t1.start();

        System.out.println("t1线程默认的中断标识：" + t1.isInterrupted());

        // 暂停毫秒
        try { TimeUnit.MILLISECONDS.sleep(2); } catch (InterruptedException e ) { e.printStackTrace() ; }

        t1.interrupt();
        System.out.println("t1线程默认的中断标识01：" + t1.isInterrupted());

        try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e ) { e.printStackTrace() ; }
        System.out.println("t1线程调用interrupt()后的中断标识03：" + t1.isInterrupted());
    }
}
