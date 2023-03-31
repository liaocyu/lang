package 桥接模式;

public class Client {
    public static void main(String[] args) {
        Phone straightPhone = new StraightPhone(new HuaWei());
        straightPhone.open();
        Phone foldPhone = new FoldPhone(new Vivo());
        foldPhone.call();
    }
}

