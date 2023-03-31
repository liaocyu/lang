package 观察者模式;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(temperature,pressure,humidity));
    }
}
