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

        logger.info("STEP 2: Open work section");
        MainPage mainPage = new MainPage();
        mainPage.getTopMenuForm().clickBtnByTitle("Работа");

        logger.info(String.format("STEP 3: searchFor %s", query));
        SearchPage searchPage = new SearchPage();
        searchPage.searchFor(query);

        logger.info(String.format("STEP 4: check Results of %s query", query));
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.checkIsVacancyCorrect(query), "query is not correct");
    }


}
