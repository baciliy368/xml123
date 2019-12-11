package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

import java.util.List;

public class ResultPage {
    List<ILabel> lblResults = new ElementFactory().findElements(By.xpath("//a[@data-position]"), ElementType.LABEL);

    public boolean checkIsVacancyCorrect(String query) {
        boolean result = true;
        for (ILabel lblResult : lblResults) {
            if (!lblResult.getText().contains(query)) {
                result=false;
            }
        }
        return result;
    }
}
