package zhouyang.cas.spinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/20 22:19
 * @description : 实现一个自旋锁SpinLockDemo
 *
 *  自旋锁的好处： 循环比较获取没有类似wait的阻塞
 *  通过CAS操作完成自旋锁 A线程先进来调用myLock方法自己持有5秒钟 B随后进来发现
 *
 *  当前线程持有锁 不是null 所以只能通过自旋等待  直到A释放锁后B随后抢到
 */
public class SpinLockDemo {

    // 声明一个原子引用自旋锁
    AtomicReference<Thread> atmoicReference = new AtomicReference<>();

    public void myLock() {
        System.out.println(Thread.currentThread().getName() + "\t" + "--------come in");

        // 设置当前线程为 null 如果设置失败 就返回 false
        while(!atmoicReference.compareAndSet(null,Thread.currentThread())){
            // 等待锁的释放


            System.out.println("呜呜呜 自旋锁被拿走了 等待锁释放的逻辑代码");
        }

        System.out.println(Thread.currentThread().getName() + "\t" + "-----------持有锁成功");

    }


    public void MyUnlock() {
        // 你知道这个 compareAndSet什么意思嘛 ？？？？
        atmoicReference.compareAndSet(Thread.currentThread() , null);

        System.out.println(Thread.currentThread().getName() + "\t" + "--------------释放锁成功");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {

            // 获得自旋锁
            spinLockDemo.myLock();

            try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e ) { e.printStackTrace() ; }

            spinLockDemo.MyUnlock();


        }, "t1").start();

        new Thread(() -> {

            spinLockDemo.myLock();

            spinLockDemo.MyUnlock();

        }, "t2").start();
    }
}
