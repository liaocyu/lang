package zhouyang.CompletableFuture;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/17 1:15
 * @description : 两个CompletionStage任务都完成后，最终能把两个任务的结果一起交给thenCombine 来处理 先完成的先等着，等待其它分支任务 thenCombine
 *
 *
 */
public class CompletableFutureAPI4 {
/*    public static void main(String[] args) {

        ExecutorService selfPool = Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            try { TimeUnit.MILLISECONDS.sleep(10000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            return 10;
        },selfPool);

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            return 20;
        },selfPool);

        CompletableFuture<Integer> thenCombinRresult = completableFuture.thenCombine(completableFuture1, (x ,y) -> {
            // 在 thenCombine这个API里面 ThreadMy是指的是当前 合并的较慢的那个线程名字
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");

            return x + y;
        });
        System.out.println(thenCombinRresult.join());
        selfPool.shutdown();
    }*/


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService selfPool = Executors.newFixedThreadPool(5);

        CompletableFuture<Integer> thenCombineResult = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in 1");
            return 10;
        },selfPool).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in 2");
            return 20;
        },selfPool), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in 3");
            return x + y;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in 4");
            return 30;
        },selfPool), (a, b) -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in 5");
            return a + b;
        });
        System.out.println("----- 主线程结束， END");
        System.out.println(thenCombineResult.get());

        selfPool.shutdown();
    }
}
