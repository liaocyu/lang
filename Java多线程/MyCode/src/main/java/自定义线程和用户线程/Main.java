package 自定义线程和用户线程;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/14 17:08
 * @description :
 */
public class Main {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon()/*判断是否是守护线程 */);
            while(true) {
                /*
                * 主线程结束了 但是用户线程还没有结束 因此 jvm还是存活状态
                * */
            }
        } , "aa");
        // 设置成 守护线程
        aa.setDaemon(true);
        aa.start(); // 创建线程

        System.out.println(Thread.currentThread().getName() + " over");
    }
}
