package factory;

import parser.ParserI;
import parserImpl.jsonParserImpl.JsonParserImpl;
import parserImpl.xmlParserImpl.XmlParserImpl;

public  class ChoiseParser {

    public ParserI getParser(String propertie){
        if (propertie.equals("xml")) {
            return new XmlParserImpl();
        }
        else if (propertie.equals("json")) {
            return new JsonParserImpl();
        }
        return null;
    }
}
