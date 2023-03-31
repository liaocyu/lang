package 原型模式.修改过后的方法;

public class Sheep implements Cloneable{
    // 要clone的java类 需要实现Cloneable接口
    private String name;
    private int age;
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public Sheep() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //克隆该实例，使用默认的克隆方法
    @Override
    protected Object clone(){
        Sheep sheep;
        try {
            sheep =(Sheep) super.clone(); // 调用父类的clone方法 默认是object
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return sheep;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
