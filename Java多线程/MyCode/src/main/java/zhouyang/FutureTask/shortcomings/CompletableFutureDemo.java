package zhouyang.FutureTask.shortcomings;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 10:39
 * @description : Future接口的缺点 容易导致阻塞 get方法不见不散
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println("进入FutureTask");
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e ) { e.printStackTrace() ; }
            return " " + ThreadLocalRandom.current().nextInt(100);
        });

         new Thread(futureTask , "t1").start();
    // 一旦调用get方法不见不散 直到get方法结束
       //  System.out.println(Thread.currentThread().getName() + "\t" + futureTask.get());
        // 设置主线程 等待时间  超出报 TimeoutException
        System.out.println(Thread.currentThread().getName() + "\t" + futureTask.get(1L, TimeUnit.SECONDS));

        System.out.println(Thread.currentThread().getName() + "\t" + " run …… here");
    }
}
