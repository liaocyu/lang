package zhouyang.longAdder;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 0:38
 * @description : vloatile 解决多线程内存不可见问题 对于一写多读 可以解决变量同步问题 但是多写的情况下 同样无法解决线程安全问题
 * 如果是 count ++ 操作 使用AtomicInteger count = new AtomicInteger() ; count.addAndGet(1) ;
 * JDK8 使用LongAdder对象 比AtomicLong性能更好 （减少乐观锁的重试次数）
 *
 * LongAdder只能用来计算加法，且从零开始计算
 */
public class LongAddreAPIDemo {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder(); // 只能做加法

        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.longValue());

        LongAccumulator longAccumulator = new LongAccumulator((left, right) -> left - right, 100) ;

        longAccumulator.accumulate(1); // 1
        longAccumulator.accumulate(2); // 3
        longAccumulator.accumulate(3); // 6

        System.out.println(longAccumulator.longValue());
    }
}
