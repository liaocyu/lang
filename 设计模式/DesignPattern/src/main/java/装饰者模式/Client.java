package 装饰者模式;

public class Client {
    public static void main(String[] args) {
        Decorator chocolate = new Chocolate(new Chocolate(new Milk(new LongBlack())));
        System.out.println(chocolate.getDescription());
        System.out.println(chocolate.cost());
    }
}
