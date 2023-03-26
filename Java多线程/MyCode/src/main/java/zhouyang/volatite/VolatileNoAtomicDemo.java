package zhouyang.volatite;

import java.util.concurrent.TimeUnit;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/19 21:44
 * @description :  描述 volatile 变量的符合操作（i ++） 不具有原子性
 */
public class VolatileNoAtomicDemo {

    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    myNumber.addPlusPlus();
            }, String.valueOf(i)).start();
        }

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.number);
    }
}

class MyNumber {
    volatile int number = 0 ;

    public void addPlusPlus() {
        number ++;
    }
}
