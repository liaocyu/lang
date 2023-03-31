package 享元模式;

public class ConcreteWebSite extends WebSite{
    private String type;
    @Override
    public void use(User user) {
        System.out.println("网站的发布形式是："+type+" 使用者是："+user.getName());
    }

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    public ConcreteWebSite() {
    }

}
