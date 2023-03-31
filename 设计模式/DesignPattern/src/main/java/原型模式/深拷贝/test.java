package 原型模式.深拷贝;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.setName("原型");
        deepPrototype.setTarget(new DeepPrototypeTarget("目标","目标"));
        DeepPrototype clone =(DeepPrototype) deepPrototype.clone();
        System.out.println(deepPrototype.getTarget().hashCode());
        System.out.println(clone.getTarget().hashCode());
    }
}
