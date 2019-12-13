package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AlertsMenu extends Form {
    private String baseJsLocator = "//button[@onclick='%s']";

    protected AlertsMenu() {
        super(By.xpath("//ul[@style='list-style-type: none;']"), "menu");
    }

    public void clickJs(String onClick) {
        getBtnJsByOnClick(onClick).click();
    }

    private IButton getBtnJsByOnClick(String onClick) {
        return new ElementFactory().getButton(By.xpath(String.format(baseJsLocator, onClick)), onClick);
    }
}
