import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.ResultPage;
import pageobject.SearchPage;

public class TestVacancy {

    @Test
    public void checkSearchVacancy() {
        PropertyConfigurator.configure("log4j.properties");
        String query = "специалист по тестированию";
        Browser browser = BrowserManager.getBrowser();
        browser.maximize();
        browser.goTo("http://tut.by");
        MainPage mainPage = new MainPage();
        mainPage.getTopMenu().clickBtnWork();
        SearchPage searchPage = new SearchPage();
        searchPage.searchFor(query);
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.checkIsVacancyCorrect(query), "query is not correct");
        browser.quit();
    }
}
