package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class AlertsMenu {
    private IButton btnJsAlert = new ElementFactory().getButton(By.xpath("//button[@onclick='jsAlert()']"), "jsAlert");
    private IButton btnJsConfirm = new ElementFactory().getButton(By.xpath("//button[@onclick='jsConfirm()']"), "JSConfirm");
    private IButton btnJsPrompt = new ElementFactory().getButton(By.xpath("//button[@onclick='jsPrompt()']"), "JSPrompt");

    public void clickJsAlert() {
        btnJsAlert.click();
    }

    public void clickJsConfirm() {
        btnJsConfirm.click();
    }

    public void clickJsPrompt() {
        btnJsPrompt.click();
    }
}
