package framework;

import ApiUtiles.BooksApi;
import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class BasicApi {
    static String url;

    public BasicApi(String url) {
        this.url = url;
    }

    public static HttpURLConnection getConnection() throws Exception {
        URL obj = new URL("http://www.mocky.io/v2/5daedf5b320000ec71d95dd7");
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");
        return connection;
    }

    public static String getTextOfResponse() throws Exception {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;
        is = new BufferedInputStream(getConnection().getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine = "";
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        return sb.toString();


    }

}

