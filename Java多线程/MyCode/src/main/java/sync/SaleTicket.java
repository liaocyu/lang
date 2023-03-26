package sync;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/14 22:36
 * @description :
 */

class Ticket {
    private int number = 30;

    public synchronized  void sale () {
        // 判断是否有票
        if(number > 0 ) {
            System.out.println(Thread.currentThread().getName() + "：卖出 " + (number --) + " 剩下：" + number);
        }
    }
}

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"CC").start();
    }


}
