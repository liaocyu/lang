package zhouyang.atomic.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/22 0:34
 * @description : 原子类 AtomicInterger的使用
 */
public class AtomicIntergerTest {

    public static void main(String[] args) {
        AtomicInteger atomi = new AtomicInteger(10);

        // 将给定的值原子地添加到当前值 。
        int i = atomi.addAndGet(10);
        System.out.println(i);

        // 如果当前值 == 预期值  则将该值原子设置未给定地更新值 如果更新成功就返回 true 否则返回 false
        boolean b = atomi.compareAndSet(20 , 30);
        System.out.println(b);
        System.out.println(atomi.get());
        // 原子减 1当前值 并且返回更新后地值 。
        i = atomi.decrementAndGet();
        System.out.println(i); // 29
        System.out.println(atomi.get());
        // 将给定地值原子地添加到当前值 并且返回更新前的值
        i = atomi.getAndAdd(50);
        System.out.println(i); // 29
        System.out.println(atomi.get()); // 79
        // 原子减1当前值  并且返回更新前的值
        i = atomi.getAndDecrement(); // 79
        System.out.println(atomi.get());// 78
        // 原子上增加一个当前值 并且返回更新前的值
        i = atomi.getAndIncrement();
        System.out.println(i);// 78
        System.out.println(atomi.get()); // 79
        //  将原子设置为给定值并返回旧值。
        i = atomi.getAndSet(100);
        System.out.println(i);// 79
        System.out.println(atomi.get());// 100
        // 原子上增加一个当前值。并且返回更新后的值。
        i = atomi.incrementAndGet();
        System.out.println(i);// 101
        System.out.println(atomi.get());// 101
    }
}
