package zhouyang.locks.fairOrUnFairLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/18 1:33
 * @description : 演示synchronized 可重入功能
 */
public class ReEnterLockDemo {

    public static void main(String[] args) {
        syncBlock();
    }
    /*synchronized的可重入演示*/
    static Object objectLock = new Object();
    public static void syncBlock()
    {
        new Thread(() -> {
            synchronized (objectLock) {// lock
                System.out.println("-----外层");
                synchronized (objectLock)
                {
                    System.out.println("-----中层");
                    synchronized (objectLock)
                    {
                        System.out.println("-----内层");
                    }
                }
            }//unlock
        },"t1").start();
    }
}
