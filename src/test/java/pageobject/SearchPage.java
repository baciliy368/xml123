package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

public class SearchPage extends Form {
    private ITextBox tbxSearch = new ElementFactory().getTextBox(By.xpath("//input[@data-qa='search-input']"), "search");
    private IButton btnSubmit = new ElementFactory().getButton(By.xpath("//button[@data-qa='search-button']"), "submit");

    public SearchPage() {
        super(By.xpath("//div[@class='supernova-dashboard-header']"), "work for everyone");
    }

    public void typeStringInSearchBox(String text) {
        Logger.getInstance().info(String.format("put %s in %s", text, tbxSearch.getName()));
        tbxSearch.type(text);
    }
    public void searchFor(String text) {
        typeStringInSearchBox(text);
        clickSearchBox();
    }
    public void clickSearchBox() {
        Logger.getInstance().info(String.format("click %s", btnSubmit.getName()));
        btnSubmit.click();
    }
}
