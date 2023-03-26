package zhouyang.atomic.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/22 0:48
 * @description : 原子类 AtomicReference的一些使用和 API
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<String> ar = new AtomicReference<>("卡卡西");
        System.out.println(ar.get()); // 卡卡西
        String s = ar.get();
        boolean b = ar.compareAndSet(s , "liaocyu啊");
        System.out.println(b); // true
        System.out.println(ar.get());// liaocyu啊
    }
}
