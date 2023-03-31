package 观察者模式;

public class CurrentCondition implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;


    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("温度为"+temperature);
        System.out.println("气压为"+pressure);
        System.out.println("湿度为"+humidity);
    }
}
