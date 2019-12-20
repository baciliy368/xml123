package testpackage;

import ApiUtiles.BooksApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PropertiesReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class BooksXmlTest extends BaseTest {
    private int numberOfRandomSymbols = 10;

    @Test
    public void testXmlBooks() throws Exception{
        logger.info("Step 1: Check status code and xml books");
        SoftAssert softAssert = new SoftAssert();
        BooksApi booksApi = new BooksApi();
        softAssert.assertEquals(200, booksApi.getConnection().getResponseCode());
        softAssert.assertEquals("application/xml; charset=UTF-8",
                booksApi.getConnection().getHeaderField("Content-Type"));
        softAssert.assertAll("Code is not 200 or it is not .xml");

        HttpURLConnection connection = booksApi.getConnection();
    }

}
