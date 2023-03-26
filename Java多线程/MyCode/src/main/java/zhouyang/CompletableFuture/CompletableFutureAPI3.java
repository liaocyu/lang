package zhouyang.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/17 0:57
 * @description : applyToEither 谁快谁用
 */
public class CompletableFutureAPI3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {

            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        // 比较异步线程 1 和 2 谁快 谁就传入参数给后面继续执行
        /* 其中的 f是completableFuture1 completableFuture2其中的一个返回值  */
        CompletableFuture<Integer> thenCombineResult = completableFuture1.applyToEither(completableFuture2, f -> {
            System.out.println(Thread.currentThread().getName() + " \t " + "---come in ");
            return f + 1;
        });
        System.out.println(Thread.currentThread().getName() + " \t " + thenCombineResult.get());
    }
}
