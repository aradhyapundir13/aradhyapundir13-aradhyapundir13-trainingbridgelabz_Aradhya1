package Day16Progs.abstractfactory;

public class LightUIComponentFactory implements UIComponentFactory{
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }
}