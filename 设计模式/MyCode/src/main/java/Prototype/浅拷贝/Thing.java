package Prototype.浅拷贝;

import java.util.ArrayList;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 20:18
 * @description :
 * 演示通过Object类的clone方放拷贝对象 -------- 浅拷贝
 */
public class Thing implements Cloneable{

    // 私有成员变量(记住 私有的)
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    //
    public void setValue(String value) {
        this.arrayList.add(value);
    }

    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}
