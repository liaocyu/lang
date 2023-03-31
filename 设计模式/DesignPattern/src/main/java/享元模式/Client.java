package 享元模式;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();
        WebSite news = factory.getWebSiteCategory("新闻");
//        WebSite news2 = factory.getWebSiteCategory("新闻");
        news.use(new User("tom"));
        WebSite blog = factory.getWebSiteCategory("博客");
        blog.use(new User("jerry"));
        System.out.println(factory.getWebSiteCount());
    }
}
