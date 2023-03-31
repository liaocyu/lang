package Prototype.cloneableDemo;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 20:01
 * @description :
 */
public class Thing implements Cloneable{


    public Thing() {
        System.out.println("我是无参构造，我被执行了");
    }

    public Thing(int num) {
        System.out.println("我的一个实例化调用Object的clone方法时，有参构造函数是不会被执行的");
        System.out.println("我是有参构造函数，我得到的num是 ：" + num);
    }

    @Override
    protected Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }
}
