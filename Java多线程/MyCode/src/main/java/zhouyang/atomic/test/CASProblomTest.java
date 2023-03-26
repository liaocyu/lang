package zhouyang.atomic.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/22 0:54
 * @description : 模拟 原子操作类的 API - CompareAdnSet 引发的问题  简称 CAS 问题
 *
 * 理论上 线程t1之前取出的3已经不是现在的 3了 ， 但是依然替换成功了
 * 原子操作类也有ABA问题 于是准备了一个心得解决方法 使用AtomicStampedReference类
 */
public class CASProblomTest {

    // 原始值为 3
    private static AtomicInteger ai = new AtomicInteger(3);

    public static void main(String[] args) {
        new Thread(() -> {
            // 取出原来的值
            int i = ai.get();// 这个值作为预期值
            // 打个盹 休眠一下
            try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e ) { e.printStackTrace() ; }
            // 使用cas替换 出现cas问题
            boolean b = ai.compareAndSet(i , 4);
            System.out.println("线程t1 将3替换为4：" + b);
        }, "t1").start();

        new Thread(() -> {
            // 去除原来的值
            int i = ai.get();

            // 将3 替换为4
            boolean b = ai.compareAndSet(i , 4);
            System.out.println("线程t2将3替换为4：" + b);
            // 再次将4替换为3
            b = ai.compareAndSet(4,3);
            System.out.println("线程t2将4替换为3：" + b);
        }, "t2").start();
    }
}
