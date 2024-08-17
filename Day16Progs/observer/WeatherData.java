package Day16Progs.observer;

public interface WeatherData {
    void registerObserver(DisplayPanel observer);
    void removeObserver(DisplayPanel observer);
    void notifyObservers();
}