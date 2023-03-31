package Prototype.浅拷贝;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 20:23
 * @description :
 * 浅拷贝时指只是拷贝原生对象 其对象的内部的数组、引用对象等都不拷贝 还是指向原生原生对象的内部元素地址
 */
public class Client {

    public static void main(String[] args) {

        Thing thing = new Thing();

        thing.setValue("liaocyu");
        // 拷贝一个对象 浅拷贝
        Thing cloneThing = thing.clone();
        cloneThing.setValue("luozyu");

        System.out.println(thing.getValue());
    }
}
