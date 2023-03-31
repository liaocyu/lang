package Prototype;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 17:53
 * @description : 设计模式 ---- Prototype原型模式的运用
 *
 * 通过使用原型模式来解决线程不安全的实列 使得多个线程在执行的过程中只有一个对象实列化
 * 在while循环中 mail.clone()方法 将对象拷贝一份 产生一个新的对象，和原有对象一样
 * 这种就是不通过new 关键字来产生一个对象，而是通过对象拷贝实现的模式就是原型模式
 *
 * 这个模式的核心就是一个clone方法 通过这个方法来进行对象的拷贝 。在java中使用 Cloneable接口来标示这个对象是可拷贝的
 *
 * 因为每个类隐式的继承了Object类 而Object类中提供了一个clone()方法，因此我们可以重写Object类的clone()方法来实现对对象的拷贝
 *
 * 在对象拷贝时，类的构造函数是不会被执行的 一个类实现了Cloneable并重写了clone方法的类A,有一个无参构造或有参构造B
 * 通过new关键字产生一个对象S 然后通过S.clone()方式产生了一个新的对象T n，那么对象拷贝时构造函数是B是不会被执行的
 */
public class client {

    // 发送账单的数量 可以从数据库进行查询 模拟发送6条短信
    private static int MAX_COUNT = 6;

    public static void main(String[] args) {
        // 模拟发送邮件
        int i = 0;
        // 定义邮件发送的模板
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("建设银行版权所有");

        while(i < MAX_COUNT) {
            // 下面是每封邮件不同的地方
            Mail cloneMail = mail.clone();
            // 设置邮件的称谓
            cloneMail.setAppellation( RandomStringUtils.randomAlphabetic(5)+ " 先生（女士）");
            // 设置邮件的收件人
            cloneMail.setReceiver( RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(8) + ".com");
            // 然后发送邮件
            sendMail(cloneMail);
            i ++;
        }
    }

    public static void sendMail(Mail mail) {
        System.out.println("标题："+ mail.getSubject() +  "\t收件人：" + mail.getReceiver() + "\t内容：" + mail.getContext() +"\t....发送成功！");
    }

}
