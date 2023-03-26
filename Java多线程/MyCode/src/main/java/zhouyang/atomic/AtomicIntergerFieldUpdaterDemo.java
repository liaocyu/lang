package zhouyang.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/21 17:05
 * @description : 原子更新引用类型字段的值
 * 使用目的： 以一种线程安全的操作非线程安全对象内的某些字段
 * 使用目的:  更新的对象属性必须使用 public volatile 修饰符。
 *           因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用静态方法newUpdater()创建一个更新器，
 *           并且需要设置想要更新的类和属性。
 */
public class AtomicIntergerFieldUpdaterDemo {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        for (int i = 1; i <= 100 ; i++) {
            new Thread(() -> bankAccount.transfer(bankAccount), String.valueOf(i)).start();
        }

        try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

        System.out.println(Thread.currentThread().getName()+"\t"+"---bankAccount: "+bankAccount.money);
    }
}

class BankAccount{

    String bankName = "ccb";
    // 更新的对象属性必须使用 public volatile 修饰符
    public volatile int money = 0;

    // 对象的属性修改类型原子类都是抽象类 每次必须使用
    // 使用静态方法 newUpdater() 创建一个更新容器 并且需要设置想要更新的类和属性

    AtomicIntegerFieldUpdater FieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");

    public void transfer(BankAccount bankAccount) {
        FieldUpdater.incrementAndGet(bankAccount);
    }
}
