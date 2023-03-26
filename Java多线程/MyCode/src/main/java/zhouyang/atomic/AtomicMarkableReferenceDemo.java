package zhouyang.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/21 16:10
 * @description : 原子更新带有标记位的引用类型对象、解决是否修改过、将状态戳简化为 true | false
 */
public class AtomicMarkableReferenceDemo {

    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100,false);

    public static void main(String[] args) {
        new Thread(() -> {

            boolean marked = atomicMarkableReference.isMarked(); // false

            System.out.println(Thread.currentThread().getName()+"\t"+"---默认修改标识："+marked);

            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            boolean b = atomicMarkableReference.compareAndSet(100,101,marked,!marked);

            System.out.println(Thread.currentThread().getName()+"\t"+"---操作是否成功:"+b);

            System.out.println(Thread.currentThread().getName()+"\t"+atomicMarkableReference.getReference());

            System.out.println(Thread.currentThread().getName()+"\t"+atomicMarkableReference.isMarked());

        }, "t1").start();

        new Thread(() -> {

            boolean marked = atomicMarkableReference.isMarked();

            System.out.println(Thread.currentThread().getName()+"\t"+"---默认修改标识："+marked);

            try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e ) { e.printStackTrace() ; }

            boolean b = atomicMarkableReference.compareAndSet(100, 20210308, marked, !marked);

            System.out.println(Thread.currentThread().getName()+"\t"+"---操作是否成功:"+b);

            System.out.println(Thread.currentThread().getName()+"\t"+atomicMarkableReference.getReference());

            System.out.println(Thread.currentThread().getName()+"\t"+atomicMarkableReference.isMarked());

        }, "t2").start();
    }
}
