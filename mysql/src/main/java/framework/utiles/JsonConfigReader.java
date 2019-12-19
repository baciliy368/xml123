package framework.utiles;

import exceptions.NoConfigFileOrParameter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonConfigReader {
    public static String getJsonParameterValue(String parameter) {
        try {
            return (String)  ((JSONObject) new JSONParser().parse(new FileReader(
                    "src/main/resources/databaseconfig.json"))).get(parameter);
        } catch (Exception e) {
            throw new NoConfigFileOrParameter();
        }
    }
}
