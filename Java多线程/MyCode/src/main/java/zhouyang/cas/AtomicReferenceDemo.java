package zhouyang.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/20 21:50
 * @description : 展示原子引用 Atomicreference 的使用
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3",24);

        User lisi = new User("lisi" , 21 , "lzy");

        User ww = new User("ww" , 26);

        AtomicReference<User> atomicReference = new AtomicReference<>();

        atomicReference.set(z3); //指定对一个引用使用原子操作类
        // 对用用赋值并获取引用的一个值  将z3这个引用赋值为lisi
        System.out.println(atomicReference.compareAndSet(z3,lisi)+"\t"+atomicReference.get().toString());
        // 我的理解是模拟第二个线程来修改它
        System.out.println(atomicReference.compareAndSet(z3,ww)+"\t"+atomicReference.get().toString());


    }
}


@Getter
@ToString
@AllArgsConstructor
class User {
    String UserName;

    int age;

    public User(String userName, int age , String message) {
        UserName = userName;
        this.age = age;

        System.out.println("我的宝贝女孩啊：" + message);
    }
}
