package 原型模式.深拷贝;

import java.io.*;

public class DeepPrototype implements Cloneable, Serializable {
    private String name;
    private DeepPrototypeTarget target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepPrototypeTarget getTarget() {
        return target;
    }

    public void setTarget(DeepPrototypeTarget target) {
        this.target = target;
    }

    //重写clone方法实现深拷贝
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Object deep = super.clone();
//        DeepPrototype deepPrototype = (DeepPrototype) deep;
//        DeepPrototypeTarget target1 =(DeepPrototypeTarget) deepPrototype.getTarget().clone();
//        deepPrototype.setTarget(target1);
//        return deepPrototype;
//    }

    //通过序列化来实现深拷贝
    @Override
    protected Object clone() {
        ByteArrayOutputStream bos;
        ByteArrayInputStream bis;
        ObjectInputStream ois;
        ObjectOutputStream oos;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); // 当前这个对象以对象流的方式输出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
