package Day16Progs.abstractfactory;

public class DarkUIComponentFactory implements UIComponentFactory{
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }
}