package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

public class JavaScriptAlertPage extends Form {
    private ILabel result = new ElementFactory().getLabel(By.id("result"), "result");

    public JavaScriptAlertPage() {
        super(By.id("result"), "JavaScript Alerts");
    }

    public void clickButton(String onClick) {
        getBtnJsByOnClick(onClick).click();
    }

    public String getTextOfResult() {
        Logger.getInstance().info("take text of result");
        return result.getText();
    }

    private IButton getBtnJsByOnClick(String onClick) {
        return new ElementFactory().getButton(By.xpath(String.format("//button[@onclick='%s']",
                onClick)), onClick);
    }
}
