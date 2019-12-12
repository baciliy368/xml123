import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.ResultPage;
import pageobject.SearchPage;

public class TestVacancy {
    String query = "специалист по тестированию";

    @BeforeTest
    public void beforeTest() {
        PropertyConfigurator.configure("log4j.properties");
        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo("http://tut.by");
    }

    @Test
    public void checkSearchVacancy() {
        MainPage mainPage = new MainPage();
        Logger.getInstance().info("check is mainPage is displayed");
        Assert.assertTrue(mainPage.isFormDisplayed(), "mainPage is not displayed");
        mainPage.getTopMenuForm().clickBtnWork();
        SearchPage searchPage = new SearchPage();
        Logger.getInstance().info("check is searchPage is displayed");
        Assert.assertTrue(searchPage.isFormDisplayed(), "searchPage is not displayed");
        searchPage.searchFor(query);
        ResultPage resultPage = new ResultPage();
        Logger.getInstance().info("check is resultPage is displayed");
        Assert.assertTrue(resultPage.isFormDisplayed(), "resultPage is not displayed");
        Logger.getInstance().info("check result of query");
        Assert.assertTrue(resultPage.checkIsVacancyCorrect(query), "query is not correct");
    }

    @AfterTest
    public void afterTest() {
        BrowserManager.getBrowser().quit();
    }
}
