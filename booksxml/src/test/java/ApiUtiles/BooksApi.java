package ApiUtiles;


import framework.BasicApi;
import org.w3c.dom.Document;
import org.w3c.dom.xpath.XPathExpression;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import utils.PropertiesReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

public class BooksApi extends BasicApi {
    private static final String url = PropertiesReader.getValue("URL_TO_GET_BOOKS");

    public BooksApi() {
        super(url);
    }

    private static Document toXmlDocument(String str) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(str)));

        return document;
    }

    public static void main(String[] args) throws Exception {

            //Parser that produces DOM object trees from XML content
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            //API to obtain DOM Document instance
            DocumentBuilder builder = null;
        Document doc = null;
        try
            {
                //Create DocumentBuilder with default configuration
                builder = factory.newDocumentBuilder();

                //Parse the content to Document object
                 doc = builder.parse(new InputSource(new StringReader(getTextOfResponse())));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        System.out.println(doc.getDocumentElement().getElementsByTagName("book").item(2));
    }
    }

