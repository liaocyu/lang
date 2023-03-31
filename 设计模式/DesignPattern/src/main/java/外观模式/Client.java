package 外观模式;

public class Client {
    public static void main(String[] args) {
        HomeController homeController = new HomeController();
        homeController.ready();
        System.out.println("-----");
        homeController.start();
        System.out.println("-----");
        homeController.stop();
    }
}
