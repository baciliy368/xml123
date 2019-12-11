import aquality.selenium.browser.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.ResultPage;
import pageobject.SearchPage;

public class TheFirstTest {

    @Test
    public void test() {
        String query = "специалист по тестированию";

        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo("http://tut.by");
        MainPage mainPage = new MainPage();
        mainPage.clickWorkTab();
        SearchPage searchPage = new SearchPage();
        searchPage.typeStringInSearchBox(query);
        searchPage.clickSearchBox();
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.isThisQuery(query), "query is not correct");
    }

    @AfterTest
    public void afterTest() {
        BrowserManager.getBrowser().quit();
    }
}
