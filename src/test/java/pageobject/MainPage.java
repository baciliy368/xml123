package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class MainPage {
    private ILabel lblExample = new ElementFactory().getLabel(By.xpath("//h1"), "Example Label");

    public boolean isThisExampleMainPage() {
        return lblExample.getText().equals("Example Domain");
    }
}
