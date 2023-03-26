package zhouyang.cas.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/20 21:21
 * @description :
 */
public class CasDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5); // 初始化

        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,109) + "\t" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,1011) + "\t" + atomicInteger.get());

    }
}
