package zhouyang.FutureTask;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 1:18
 * @description : Future 和线程池异步多线程任务配合 能显著提高程序的执行效率
 */
public class FutureThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask1 = new FutureTask<>( () -> {
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<>( () -> {
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }
            return "task2 over";
        });
        threadPool.submit(futureTask2);

        // 获取 线程1 2 的返回结果
        futureTask1.get();
        futureTask2.get();


         Long startTime = System.currentTimeMillis();
         try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }

         Long endTime = System.currentTimeMillis();
         System.out.println("------costTime："+(endTime - startTime) + " 毫秒");


         System.out.println(Thread.currentThread().getName() + "\t ------ end ");

         threadPool.shutdown(); // 关闭资源池

    }

    private static void m() {
        Long startTime = System.currentTimeMillis();
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e ) { e.printStackTrace() ; }

        Long endTime = System.currentTimeMillis();
        System.out.println("------costTime："+(endTime - startTime) + " 毫秒");
    }
}
