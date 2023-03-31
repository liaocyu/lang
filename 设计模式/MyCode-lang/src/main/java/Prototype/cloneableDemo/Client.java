package Prototype.cloneableDemo;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 20:05
 * @description : 在这个类中 我主要演示的类的实例通过clone拷贝的对象是不会执行类的有参构造的
 */
public class Client {
    public static void main(String[] args) {
        Thing thing = new Thing();

        Thing cloneThing = thing.clone();
    }
}
