package pageobject;

import aquality.selenium.elements.ElementFactory;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import util.Decoder;
import java.util.List;

public class ResultPage {
    List<ILabel> labels = new ElementFactory().findElements(By.xpath("//a[@data-position]"), ElementType.LABEL);

    public boolean isThisQuery(String query) {
        int counter = 0;
        for (ILabel label : labels) {
            if (Decoder.getDecode(label.getAttribute("href")).replaceAll(".+query=", "").equals(query)) {
                counter++;
            }
        }
        return labels.size() == counter;
    }
}
