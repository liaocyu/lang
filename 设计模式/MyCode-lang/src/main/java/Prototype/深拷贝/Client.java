package Prototype.深拷贝;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 20:23
 * @description :
 * 深拷贝时 拷贝原生对象 其对象的内部的数组、引用对象等都拷贝
 */
public class Client {

    public static void main(String[] args) {

        Prototype.深拷贝.Thing thing = new Prototype.深拷贝.Thing();

        thing.setValue("liaocyu");
        // 拷贝一个对象 浅拷贝
        Thing cloneThing = thing.clone();
        cloneThing.setValue("luozyu");

        System.out.println(thing.getValue());
    }
}
