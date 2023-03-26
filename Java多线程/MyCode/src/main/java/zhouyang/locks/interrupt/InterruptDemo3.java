package zhouyang.locks.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 1:50
 * @description : 当线程处于阻塞状态 此时去调用线程的interrupt方法 会出现InterruptedException异常
 */
public class InterruptDemo3 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t 线程-------isInterrupt() = true,自己退出了");
                    break;
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }

                System.out.println("Hello ---------------interrupt");
            }

        }, "t1");

        t1.start();

        try {TimeUnit.MILLISECONDS.sleep(1);}catch (Exception e) {e.printStackTrace();}

        t1.interrupt();
    }
}
