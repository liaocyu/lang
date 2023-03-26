package zhouyang.threadLocal;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/23 16:43
 * @description : 定义了一个 ThreadLocal对象threadlocal .使用withInitial方法可以为每一个线程初始化一个值 这个值会在该线程第一次访问该变量时候被创建
 * 在后续的访问中 每个线程都将使用自己的局部变量副本 互相不会有影响
 */

class House {
    // 第一次创建就会初始化一个 int整形的函数 后面的访问中就不会都将使用自己的局部变量的副本
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public void saleHouse(){
        Integer value = threadLocal.get();
        ++value;
        threadLocal.set(value);
    }
}

public class ThreadLocalDemo2{

    public static void main(String[] args){
        House house = new House();

        new Thread(() -> {
            try{
                for (int j = 1; j <=3; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get()); // 3
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                // 如果不清理自定义的  ThreadLocal  变量，可能会影响后续业务逻辑和造成内存泄露等问题
                house.threadLocal.remove();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                for (int j = 1; j <=2; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                house.threadLocal.remove();
            }
        },"t2").start();

        new Thread(() -> {
            try{
                for (int j = 1; j <=5; j++) {
                    house.saleHouse();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                house.threadLocal.remove();
            }
        },"t3").start();

        System.out.println(Thread.currentThread().getName()+"\t"+"---卖出： "+house.threadLocal.get());

    }
}

