package pajeobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;
import lombok.Getter;
import org.openqa.selenium.By;

public class JavaScriptAlertPage extends Form {
    @Getter
    private AlertsMenu alertsMenu = new AlertsMenu();
    private ILabel result = new ElementFactory().getLabel(By.id("result"), "result");

    public String getTextOfResult() {
        Logger.getInstance().info("take text of result");
        return result.getText();
    }

    public JavaScriptAlertPage() {
        super(By.xpath("//ul[@style='list-style-type: none;']"), "JavaScript Alerts");
    }
}
