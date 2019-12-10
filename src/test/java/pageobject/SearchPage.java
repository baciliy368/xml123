package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class SearchPage {
    private ITextBox searchBox = new ElementFactory().getTextBox(By.xpath("//input[@data-qa='search-input']"), "searchTextBox");
    private IButton searchButton = new ElementFactory().getButton(By.xpath("//button[@data-qa='search-button']"), "searchButton");

    public void typeStringInSearchBox(String text) {
        searchBox.type(text);
    }

    public void clickSearchBox() {
        searchButton.click();
    }
}
