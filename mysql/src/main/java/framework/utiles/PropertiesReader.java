package framework.utiles;

import exceptions.NoConfigFileOrParameter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String getValue(String key) {
        InputStream input;
        Properties prop = new Properties();
        try {
            input = new FileInputStream("src/main/resources/sqlscripts.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NoConfigFileOrParameter();
        }
        return prop.getProperty(key);
    }
}

