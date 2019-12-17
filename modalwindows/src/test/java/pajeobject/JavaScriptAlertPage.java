package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

public class JavaScriptAlertPage extends Form {
    private ILabel result = new ElementFactory().getLabel(By.id("result"), "result");
    private final String JS_BUTTON_LOCATOR_TEMPLATE = "//button[@onclick='%s']";
    private IButton btnAlert = new ElementFactory().getButton(By.xpath(String.format(JS_BUTTON_LOCATOR_TEMPLATE,
            "jsAlert()")), "jsAlert()");
    private IButton btnConfirm = new ElementFactory().getButton(By.xpath(String.format(JS_BUTTON_LOCATOR_TEMPLATE,
            "jsConfirm()")), "jsConfirm()");
    private IButton btnPrompt = new ElementFactory().getButton(By.xpath(String.format(JS_BUTTON_LOCATOR_TEMPLATE,
            "jsPrompt()")), "jsPrompt()");

    public JavaScriptAlertPage() {
        super(By.id("result"), "JavaScript Alerts");
    }

    public void clickButtonAlert() {
        btnAlert.click();
    }

    public void clickButtonConfirm() {
        btnConfirm.click();
    }

    public void clickButtonPrompt() {
        btnPrompt.click();
    }

    public String getTextOfResult() {
        Logger.getInstance().info("take text of result");
        return result.getText();
    }
}
