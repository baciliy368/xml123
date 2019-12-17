package pageobject;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private TopMenu topMenuForm = new TopMenu();

    public TopMenu getTopMenuForm() {
        return topMenuForm;
    }

    public MainPage() {
        super(By.xpath("//a[@class='header-logo']"), "logoTutBy");
    }
}
