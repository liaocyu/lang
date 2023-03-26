package zhouyang.locks.fairOrUnFairLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/18 1:33
 * @description : 演示synchronized 可重入功能
 */
public class ReEnterLockDemo2 {

    public static void main(String[] args) {
        ReEnterLockDemo2 reEntryLockDemo = new ReEnterLockDemo2();
        reEntryLockDemo.m1();
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "\t");
        System.out.println("-----m1");
        m2();
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "\t");
        System.out.println("-----m2");
        m3();
    }

    public synchronized void m3() {
        System.out.println(Thread.currentThread().getName() + "\t");
        System.out.println("-----m3");
    }


}
