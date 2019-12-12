package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

public class TopMenu {
    private IButton btnWork = new ElementFactory().getButton(By.xpath("//ul[@class='b-topbar-i']//a[@title='Работа']"), "Work");

    public void clickBtnWork() {
        Logger.getInstance().info(String.format("click button %s", btnWork.getName()));
        btnWork.click();
    }
}
