package zhouyang.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/20 21:04
 * @description :  多线程环境 使用原子类保证线程安全 （基本数据类型）
 */
public class EnsureAtomicity2 {

    AtomicInteger atomicInteger = new AtomicInteger();

    public int getAtomicInteger() {
        return atomicInteger.get();
    }

    // 保证写入原子性
    public void setAtomicInteger() {
        atomicInteger.getAndIncrement();
    }

}
