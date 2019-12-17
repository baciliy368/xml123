package testpackage;

import framework.BrowserAlertManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeobject.JavaScriptAlertPage;

public class AlertWindowsTest extends BaseTest {
    private int numberOfRandomSymbols = 10;

    @Test
    public void jsAlertTest() {
        logger.info("Step 1: Click for JS Alert");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.clickButtonAlert();
        Assert.assertEquals("I am a JS Alert", BrowserAlertManager.getTextOfAlert(),  "alert fail");

        logger.info("Step 2: click OK in JSAlert");
        BrowserAlertManager.acceptAlert();
        Assert.assertEquals("You successfuly clicked an alert", javaScriptAlertPage.getTextOfResult(),
                "result us not correct");

        logger.info("Step 3: Click for JS Confirm");
        javaScriptAlertPage.clickButtonConfirm();
        Assert.assertEquals("I am a JS Confirm", BrowserAlertManager.getTextOfAlert(), "alertConfirm fail");

        logger.info("Step 4: click OK in JS Confirm");
        BrowserAlertManager.acceptAlert();
        Assert.assertEquals("You clicked: Ok", javaScriptAlertPage.getTextOfResult(),
                "result us not correct");

        logger.info("Step 5: Click for JS Prompt");
        javaScriptAlertPage.clickButtonPrompt();
        Assert.assertEquals("I am a JS prompt", BrowserAlertManager.getTextOfAlert(), "alertPrompt fail");

        logger.info("Step 6: type random string and click OK in JS Prompt");
        String randomStingForPromptAlert = RandomStringUtils.randomAlphabetic(numberOfRandomSymbols);
        BrowserAlertManager.sendTextToAlert(randomStingForPromptAlert);
        Assert.assertEquals(String.format("You entered: %s", randomStingForPromptAlert), javaScriptAlertPage.getTextOfResult(),
                "result is not correct");
    }
}
