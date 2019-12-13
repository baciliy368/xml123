package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TopMenu extends Form {
    private String baseLocator = "//ul[@class='b-topbar-i']//a[@title='%s']";

    protected TopMenu() {
        super(By.xpath("//ul[@class='b-topbar-i']"), "topMenu");
    }

    public void clickBtnByTitle(String nameOfButton) {
        getIButtonByTitle(nameOfButton).click();
    }

    private IButton getIButtonByTitle(String nameOfButton) {
        return new ElementFactory().getButton(By.xpath(String.format(baseLocator, nameOfButton)), nameOfButton);
    }
}
