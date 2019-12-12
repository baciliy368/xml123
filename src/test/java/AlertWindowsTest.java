import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import framework.Alert;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeobject.JavaScriptAlertPage;

public class AlertWindowsTest {
    int numberOfRandomSymbols = 10;

    @BeforeTest
    public void beforeTest() {
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void jsAlertTest() {
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        Logger.getInstance().info("check page is it main page");
        Assert.assertTrue(javaScriptAlertPage.isFormDisplayed(), "allert page is not displayed");
        javaScriptAlertPage.getAlertsMenu().clickJsAlert();
        Logger.getInstance().info("check text of alert");
        Assert.assertEquals(Alert.getTextOfAlert(), "I am a JS Alert", "alert fail");
        Alert.acceptAlert();
        Logger.getInstance().info("check result of accepting of alert");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You successfuly clicked an alert",
                "result us not correct");
        javaScriptAlertPage.getAlertsMenu().clickJsConfirm();
        Logger.getInstance().info("check text of alert");
        Assert.assertEquals(Alert.getTextOfAlert(), "I am a JS Confirm", "alertConfirm fail");
        Alert.acceptAlert();
        Logger.getInstance().info("check text of result");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You clicked: Ok",
                "result us not correct");
        javaScriptAlertPage.getAlertsMenu().clickJsPrompt();
        Logger.getInstance().info("check text of alert");
        Assert.assertEquals(Alert.getTextOfAlert(), "I am a JS prompt", "alertPrompt fail");
        String randomStingForPromptAlert = RandomStringUtils.randomAlphabetic(numberOfRandomSymbols);
        Alert.sendTextToAlert(randomStingForPromptAlert);
        Logger.getInstance().info("check text of result");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), String.format("You entered: %s", randomStingForPromptAlert),
                "result us not correct");
    }

    @AfterTest
    public void afterTest() {
        BrowserManager.getBrowser().quit();
    }
}
