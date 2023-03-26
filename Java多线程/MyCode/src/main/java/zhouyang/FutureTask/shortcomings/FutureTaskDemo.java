package zhouyang.FutureTask.shortcomings;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 10:49
 * @description :
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + " ----新开的一个线程进来了");
            try { TimeUnit.MILLISECONDS.sleep(1); } catch (InterruptedException e ) { e.printStackTrace() ; }

            return 666666;
        });

        new Thread(futureTask , "t1").start();
        // 使用轮询 方式等待完成
        while(true) {
            if(futureTask.isDone()) {
                System.out.println("----result: "+ futureTask.get());
                break;
            }else {
                System.out.println("等我一下 马上执行完列");
            }
        }

    }
}
