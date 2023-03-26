package zhouyang.FutureTask;

import java.util.concurrent.*;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/16 0:31
 * @description : 目的 ： 异步多线程任务且有返回结果
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());

        Thread t1 = new Thread(futureTask , "t1");

        t1.start();
        // 获取FutureTask执行后的结果
        System.out.println(futureTask.get());

    }

}

/**
 * Runnable接口没有返回值
 */
class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("FutureTask 实列开启一个独立线程 执行这里面的方法");
        return "不认输";
    }
}


