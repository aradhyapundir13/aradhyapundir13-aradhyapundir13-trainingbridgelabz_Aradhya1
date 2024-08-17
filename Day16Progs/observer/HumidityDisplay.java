package Day16Progs.observer;

public class HumidityDisplay implements DisplayPanel{
    private float humidity;

    @Override
    public void update(float temperature, float humidity) {
        this.humidity = humidity;
        display();
    }
    public void display() {
        System.out.println("Current humidity: " + humidity + "%");
    }
}