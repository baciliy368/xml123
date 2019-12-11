package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class SearchPage {
    private ITextBox tbxSearch = new ElementFactory().getTextBox(By.xpath("//input[@data-qa='search-input']"), "search");
    private IButton btnSubmit = new ElementFactory().getButton(By.xpath("//button[@data-qa='search-button']"), "submit");

    public void typeStringInSearchBox(String text) {
        tbxSearch.type(text);
    }
    public void searchFor(String text) {
        typeStringInSearchBox(text);
        clickSearchBox();
    }
    public void clickSearchBox() {
        btnSubmit.click();
    }
}
