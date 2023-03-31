package 观察者模式;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentCondition currentCondition = new CurrentCondition();
        weatherData.registerObserver(currentCondition);
        weatherData.setData(20,30,40);

    }
}
