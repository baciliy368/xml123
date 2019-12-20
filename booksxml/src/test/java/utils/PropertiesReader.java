package utils;

import exceptions.NoPropertiesFileException;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static Logger logger = Logger.getLogger(PropertiesReader.class);

    public static String getValue(String key) {
        InputStream input;
        Properties prop = new Properties();
        try {
            input = new FileInputStream("src/test/resources/testData.properties");
            prop.load(input);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new NoPropertiesFileException();
        }
        return prop.getProperty(key);
    }
}

