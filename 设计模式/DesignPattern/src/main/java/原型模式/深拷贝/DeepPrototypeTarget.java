package 原型模式.深拷贝;

import java.io.Serializable;

public class DeepPrototypeTarget implements Cloneable, Serializable {
    private String name;
    private String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DeepPrototypeTarget(String name, String className) {
        this.name = name;
        this.className = className;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
