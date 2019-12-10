package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class MainPage {
    private IButton workTab = new ElementFactory().getButton(By.xpath("//ul[@class='b-topbar-i']//a[@title='Работа']"), "workTab");

    public void clickWorkTab() {
        workTab.click();
    }
}
