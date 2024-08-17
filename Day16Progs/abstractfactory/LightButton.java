package Day16Progs.abstractfactory;

public class LightButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Light Button");
    }
}