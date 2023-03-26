package zhouyang.longAccumulator;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 0:51
 * @description : LongAccumulator提供了自定义的函数操作：long类型的聚合器，需要传入一个long类型的二元操作，可以用来计算各种聚合操作，包括加乘等
 */

public class LongAccumulatorDemo {

    LongAdder longAdder = new LongAdder();


    public void add_LongAdder() {

        longAdder.increment();

    }


    //LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y,0);

    LongAccumulator longAccumulator = new LongAccumulator((left, right) -> left - right, 777);


    public void add_LongAccumulator() {

        longAccumulator.accumulate(1);

    }


    public static void main(String[] args) {

        LongAccumulatorDemo demo = new LongAccumulatorDemo();

        demo.add_LongAccumulator();

        demo.add_LongAccumulator();

        System.out.println(demo.longAccumulator.longValue());

    }


}

