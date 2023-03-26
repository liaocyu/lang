package zhouyang.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/21 15:43
 * @description : 数组类型原子类
 */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[5]);

        // 因为没有初始化 数出来全是0
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }

        System.out.println();

        System.out.println();

        System.out.println();

        int tmpInt = 0;
        // 获取并赋值
        tmpInt = atomicIntegerArray.getAndSet(0 , 1122);

        System.out.println(tmpInt+"\t"+atomicIntegerArray.get(0));

        atomicIntegerArray.getAndIncrement(1);
        atomicIntegerArray.getAndIncrement(1);
        tmpInt = atomicIntegerArray.getAndIncrement(1);
        System.out.println(tmpInt+"\t"+atomicIntegerArray.get(1));
    }
}
