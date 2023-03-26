package zhouyang.atomic.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/22 1:05
 * @description : 解决ABA问题 给每个值增加一个 "印记"
 */
public class AtomicStampReferenceTest {

    private static AtomicStampedReference<String> asr = new AtomicStampedReference<>("卡卡西",1);

    public static void main(String[] args) {

        new Thread(() -> {

            // 取值
            String s = asr.getReference();
            // 获取印记
            int stamp = asr.getStamp();
            // 打盹
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e ) { e.printStackTrace() ; }
            // 替换值  参数说明（原始值 ， 新值 ， 原始印记 ， 新的印记）
            boolean b = asr.compareAndSet("卡卡西","旗木卡卡西",stamp,stamp+1);
            System.out.println("线程t1，替换的结果："+b); // false
        }, "t1").start();

        new Thread(() -> {

            // 取值
            String s = asr.getReference();
            // 获取印记
            int stamp = asr.getStamp();
            // 第一次替换值  参数说明(原始值，新值，原始印记，新的印记)
            boolean b = asr.compareAndSet("卡卡西","旗木五五开",stamp,stamp+1);
            System.out.println("线程t2，第一次替换的结果："+b); // true
            // 第二次替换值  参数说明(原始值，新值，原始印记，新的印记)
            b = asr.compareAndSet("旗木五五开","卡卡西",stamp,stamp+1);
            System.out.println("线程2，第二次替换的结果："+b); // false

        }, "t2").start();
    }
}
