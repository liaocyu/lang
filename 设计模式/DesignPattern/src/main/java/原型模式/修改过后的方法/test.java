package 原型模式.修改过后的方法;

public class test {
    public static void main(String[] args) {
        System.out.println("使用原型模式创建sheep对象");
        Sheep sheep = new Sheep("sheep", 10, "black");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);
    }


}
