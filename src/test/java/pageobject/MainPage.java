package pageobject;

import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;

public class MainPage extends Form {
    @Getter
    TopMenu topMenuForm = new TopMenu();

    public MainPage() {
        super(By.xpath("//a[@class='header-logo']"), "logoTutBy");
    }
}
