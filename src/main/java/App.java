import parserImpl.jsonParserImpl.JsonParserImpl;
import parserImpl.xmlParserImpl.XmlParserImpl;

public class App {
    public static void main(String[] args) {

/*
        XmlParserImpl xmlParser = new XmlParserImpl();
        xmlParser.parser();
*/

        JsonParserImpl jsonParser = new JsonParserImpl();
        jsonParser.parser();

    }
}
