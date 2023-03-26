package zhouyang.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 22:37
 * @description : CompletableFuture的API
 */
public class CompletableFutureAPI {
    public static void main(String[] args) {
        // 自定义线程
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }

            System.out.println("1111");
            return 1 ;
        } , threadPool).thenApply( f  -> {
            System.out.println("2222");
            return f + 1;
            // 在这里使用handle 当前结果出现异常 继续带着参数向下执行 相当于 try {} catch {} finally 起作用就是和 thenApply一样
        }).thenApply(f  -> {
            // int i = 10 / 0;
            System.out.println("3333");
            return f + 1 ;
        }).whenCompleteAsync((v , e) -> { // 传入的是value 和 exception
            if(e == null ) {
                System.out.println("经过三级循环得出的 v是 " + v);
            }
        }).whenComplete((v ,e) -> {
            System.out.println("whenComplete执行完后还是会执行whenComplete里面的方法");
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        // 如果使用默认的线程池 当主线程运行完之后 线程池也会关闭 得不出我们想要的结果 建议使用通过我们自定义的线程池
        System.out.println(Thread.currentThread().getName() + "\t");
        threadPool.shutdown();

        System.out.println("whenCompleteAsync执行完后继续交给线程池的处理");

    }
}
