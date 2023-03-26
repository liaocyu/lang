package zhouyang.locks.fairOrUnFairLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/18 0:51
 * @description : 通过买票演示公平锁和非公平锁
 */
public class SaleTicketDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> { for (int i = 1; i <=55; i++) ticket.sale(); },"a").start();
        new Thread(() -> { for (int i = 1; i <=55; i++) ticket.sale(); },"b").start();
        new Thread(() -> { for (int i = 1; i <=55; i++) ticket.sale(); },"c").start();
        new Thread(() -> { for (int i = 1; i <=55; i++) ticket.sale(); },"d").start();
        new Thread(() -> { for (int i = 1; i <=55; i++) ticket.sale(); },"e").start();

    }
}

class Ticket{
    private  int number = 50;

    private Lock lock = new ReentrantLock(true);// 默认使用的是非公平锁 分配的平均一点

/*    public void sale(){
        lock.lock();
        try
        {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t 卖出第: "+(number--)+"\t 还剩下: "+number);
            }
        }finally {
            lock.unlock();
        }
    }*/

    Object objectLock = new Object();

    public void sale()
    {
        synchronized (objectLock)
        {
            if(number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t 卖出第: "+(number--)+"\t 还剩下: "+number);
            }
        }
    }

}
