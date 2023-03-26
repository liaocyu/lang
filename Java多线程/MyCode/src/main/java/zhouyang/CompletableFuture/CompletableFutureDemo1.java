package zhouyang.CompletableFuture;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 11:16
 * @description : 核心四个静态方法 runAsync没有返回值
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 自定义线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);


        CompletableFuture<Void> future  = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            // 模拟业务代码执行 1s
            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            System.out.println("------task is over ");
        } , threadPool);

        System.out.println(future.get());
        threadPool.shutdown();
    }
}
