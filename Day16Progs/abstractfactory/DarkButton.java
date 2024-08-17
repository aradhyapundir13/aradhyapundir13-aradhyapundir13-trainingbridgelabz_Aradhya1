package Day16Progs.abstractfactory;

public class DarkButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Dark Button");
    }
}