package Day16Progs.observer;

import java.util.ArrayList;

public class WeatherStation implements WeatherData{
    private ArrayList<DisplayPanel> observers;
    private float temperature;
    private float humidity;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(DisplayPanel observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DisplayPanel observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(DisplayPanel observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    public void setWeatherData(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }
}