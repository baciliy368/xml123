package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class MainPage {
    private ILabel workTab = new ElementFactory().getLabel(By.xpath("//h1"), "Example Label");

    public boolean isThisPage() {
        return workTab.getText().equals("Example Domain");
    }
}
