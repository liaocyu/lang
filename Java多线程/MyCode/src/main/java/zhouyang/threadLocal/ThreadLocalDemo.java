package zhouyang.thread;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 16:32
 * @description :
 */
public class ThreadLocalDemo {
    // 准备三个ThreadLocal对象，分别是大锤、大黄和大牛
    static ThreadLocal dachui = new ThreadLocal();
    static ThreadLocal dahuang = new ThreadLocal();
    static ThreadLocal daniu = new ThreadLocal();

    public static void main(String[] args) {
        // 开启一个洗澡的线程
        new Thread(()->{
            tuoyifu();// 先脱衣服放入自己的柜子里，去洗澡
            chuanyifu();// 洗好澡，从自己的柜子中取出自己的衣服
        },"洗澡-按摩").start();
    }
    // 脱衣服放入柜子的流程
    public static void tuoyifu(){
        dachui.set("8007号柜子-大锤的阿玛尼");
        dahuang.set("8008号柜子-大黄的美特斯邦威");
        daniu.set("8009号柜子-大牛的奔驰大衣");
    }
    // 从柜子中取出衣服的流程
    public static void chuanyifu(){
        System.out.println("大锤 取出 " + dachui.get());
        System.out.println("大黄 取出 " + dahuang.get());
        System.out.println("大牛 取出 " + daniu.get());
    }
}