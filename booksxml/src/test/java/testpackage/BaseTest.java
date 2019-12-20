package testpackage;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import utils.PropertiesReader;

public class BaseTest {
    protected Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void beforeTest() {
        PropertyConfigurator.configure(PropertiesReader.getValue("logFilePropertyPath"));
    }
}
