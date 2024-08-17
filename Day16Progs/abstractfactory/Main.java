package Day16Progs.abstractfactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UIComponentFactory factory;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the theme: ");
        String theme = sc.nextLine();
        if(theme.equalsIgnoreCase("LIGHT")) {
            factory = new LightUIComponentFactory();
        } else if (theme.equalsIgnoreCase("DARK")) {
            factory = new DarkUIComponentFactory();
        } else {
            throw new IllegalArgumentException("Unknown theme: " + theme);
        }
        Button button = factory.createButton();
        TextField textField = factory.createTextField();

        button.render();
        textField.render();
    }
}