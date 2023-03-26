package zhouyang.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/21 10:45
 * @description : 实例原子整型类 使用 CountDownLatch 来保证线程的
 *
 * 关于 CountDownLatch 一种通用的同步工具 一个 CountDownLatch初始化计算的一个作为一个简单的 开/关锁门
 * 所有线程调用await在门口等候直到它被一个线程调用countDown()打开。
 * 一个CountDownLatch初始化n可以用来使一个线程等待直到n个线程完成一些动作 或一些行动已经完成N次。
 */
public class AtomicIntergerDemo {

    public static final int SIEZ_ = 50;

    public static void main(String[] args) throws InterruptedException {
        MyNumber myNumber = new MyNumber();

        CountDownLatch countDownLatch = new CountDownLatch(SIEZ_);

        for (int i = 1; i <= SIEZ_; i++) {

            new Thread(() -> {

                try{
                    for (int j = 1 ;j <=1000; j++) {
                        myNumber.addPlus();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                    countDownLatch.countDown();
                }

            },String.valueOf(i)).start();
        }

        // 所有线程调用 await等候 直到它被一个线程调用countDown()打开
        countDownLatch.await();

        // try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }
        System.out.println(Thread.currentThread().getName() + "\t" + "---reusult：" + myNumber.atomicInteger.get());

    }
}
class  MyNumber {
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addPlus() {
        atomicInteger.incrementAndGet();// 获取当前值 并自增
    }
}