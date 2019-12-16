package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;

import org.openqa.selenium.By;

public class JavaScriptAlertPage extends Form {
    private AlertsMenu alertsMenu = new AlertsMenu();
    private ILabel result = new ElementFactory().getLabel(By.id("result"), "result");

    public AlertsMenu getAlertsMenu() {
        return alertsMenu;
    }

    public String getTextOfResult() {
        Logger.getInstance().info("take text of result");
        return result.getText();
    }

    public JavaScriptAlertPage() {
        super(By.id("result"), "JavaScript Alerts");
    }
}
