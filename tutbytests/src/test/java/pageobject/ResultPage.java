package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

import java.util.List;

public class ResultPage extends Form {
    List<ILabel> lblResults = new ElementFactory().findElements(By.xpath("//a[@data-position]"), ElementType.LABEL);

    public ResultPage() {
        super(By.xpath("//a[@data-position]"), "resultOfQuery");
    }


    public boolean checkIsVacancyCorrect(String query) {
        boolean result = true;
        Logger.getInstance().info("check correct value of results");
        for (ILabel lblResult : lblResults) {
            if (!lblResult.getText().contains(query)) {
                result = false;
            }
        }
        return result;
    }
}
