package testpackage;

import aquality.selenium.browser.BrowserManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.MainPage;
import pageobject.ResultPage;
import pageobject.SearchPage;
import utils.PropertiesReader;

public class TestVacancy extends BaseTest {
    private String query = "специалист по тестированию";

    @Test
    public void checkSearchVacancy() {
        logger.info("Step 1: Open main page");
        BrowserManager.getBrowser().goTo(PropertiesReader.getValue("START_TUT_BY_PAGE"));

        logger.info("STEP 2:");
        MainPage mainPage = new MainPage();
        logger.info("Open work section");
        mainPage.getTopMenuForm().clickBtnByTitle("Работа");

        logger.info("STEP 3:");
        SearchPage searchPage = new SearchPage();
        logger.info(String.format("STEP 3: \nsearchFor %s", query));
        searchPage.searchFor(query);

        logger.info("STEP 4:");
        ResultPage resultPage = new ResultPage();
        logger.info(String.format("check Results of %s query", query));
        Assert.assertTrue(resultPage.checkIsVacancyCorrect(query), "query is not correct");
    }


}
