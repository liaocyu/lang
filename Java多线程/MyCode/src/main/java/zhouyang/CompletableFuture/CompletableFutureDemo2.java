package zhouyang.CompletableFuture;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 11:16
 * @description : 核心四个静态方法 supplyAsync有返回值
 */
public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future  = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");

            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }


            return ThreadLocalRandom.current().nextInt(100); //随机打印 0- 100的随机数
        });

        System.out.println(future.get());
    }
}
