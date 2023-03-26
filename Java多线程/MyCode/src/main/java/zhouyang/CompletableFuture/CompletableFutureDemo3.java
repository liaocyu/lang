package zhouyang.CompletableFuture;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 11:16
 * @description : 优点 ： 减少阻塞和轮询 可以传入回调对象 当异步任务完成或者发生异常时 自动回调对象的回调方法
 */
public class CompletableFutureDemo3 {

    public static void main(String[] args) {

        // 自定义线程池
        ExecutorService selfThreadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> future  = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");


                int result  =  ThreadLocalRandom.current().nextInt(10); //随机打印 0- 100的随机数
                // 模拟业务代码 耗时1s
                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

                System.out.println("-----计算结束耗时1秒钟 result： " + result);

                if(result > 2) {
                    int age = 10 / 0;
                }
                return result;
            } , selfThreadPool).whenComplete((v , e) -> { // 表示上一步完成的结果拿到后面的进去计算
                if(e == null) {
                    System.out.println("------修改后的result:" + v + 10);
                }
            } ).exceptionally(e -> {
                System.out.println("-------exception：" + e.getCause() + "\t" + e.getMessage());
                return -44;
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            selfThreadPool.shutdown();
        }

        // 主线程不要立刻结束，否则 CompletableFuture 默认使用的线程池会立刻关闭 : 暂停 3 秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
