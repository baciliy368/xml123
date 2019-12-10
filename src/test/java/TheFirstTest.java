import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.ResultPage;
import pageobject.SearchPage;

public class TheFirstTest {

    @Test
    public void test() {
        String query = "специалист по тестированию";
        Browser browser = BrowserManager.getBrowser();
        browser.maximize();
        browser.goTo("http://tut.by");
        MainPage mainPage = new MainPage();
        mainPage.clickWorkTab();
        SearchPage searchPage = new SearchPage();
        searchPage.typeStringInSearchBox(query);
        searchPage.clickSearchBox();
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.isThisQuery(query), "query is not correct");
        browser.quit();
    }
}
