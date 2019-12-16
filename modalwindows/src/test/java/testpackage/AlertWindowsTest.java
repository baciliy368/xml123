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
        javaScriptAlertPage.clickButton("jsAlert()");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS Alert", "alert fail");

        logger.info("Step 2: click OK in JSAlert");
        BrowserAlertManager.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You successfuly clicked an alert",
                "result us not correct");

        logger.info("Step 3: Click for JS Confirm");
        javaScriptAlertPage.clickButton("jsConfirm()");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS Confirm", "alertConfirm fail");

        logger.info("Step 4: click OK in JS Confirm");
        BrowserAlertManager.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You clicked: Ok",
                "result us not correct");

        logger.info("Step 5: Click for JS Prompt");
        javaScriptAlertPage.clickButton("jsPrompt()");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS prompt", "alertPrompt fail");

        logger.info("Step 6: type random string and click OK in JS Prompt");
        String randomStingForPromptAlert = RandomStringUtils.randomAlphabetic(numberOfRandomSymbols);
        BrowserAlertManager.sendTextToAlert(randomStingForPromptAlert);
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), String.format("You entered: %s", randomStingForPromptAlert),
                "result is not correct");
    }
}
