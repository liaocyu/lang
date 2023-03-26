package zhouyang.cas;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/20 20:54
 * @description :
 */
public class EnsureAtomicity {

    volatile int number = 0;

    public static void main(String[] args) {

    }

    // 多线程不适用原子类保证线程安全(基本数据类型)
    // 读取
    public int getNumber() {
        return number;
    }

    // 写入锁保证原子性

    public synchronized void setNumber() {
        number ++;
    }
}
