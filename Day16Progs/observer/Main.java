package Day16Progs.observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
        HumidityDisplay humidityDisplay = new HumidityDisplay();

        weatherStation.registerObserver(temperatureDisplay);
        weatherStation.registerObserver(humidityDisplay);

        weatherStation.setWeatherData(25.5f, 60.0f);
        weatherStation.setWeatherData(27.3f, 65.0f);

        weatherStation.removeObserver(humidityDisplay);
        weatherStation.setWeatherData(30.2f, 70.0f);
    }
}