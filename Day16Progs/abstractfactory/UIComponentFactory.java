package Day16Progs.abstractfactory;

import java.awt.*;

public interface UIComponentFactory {
    Button createButton();
    TextField createTextField();
}