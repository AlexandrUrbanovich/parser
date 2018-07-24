package factory;

import org.apache.log4j.Logger;
import parser.ParserI;
import parserImpl.jsonParserImpl.JsonParserImpl;
import parserImpl.xmlParserImpl.XmlParserImpl;



public  class ChoiseParser {

    private static final Logger log = Logger.getLogger(String.valueOf(ChoiseParser.class));

    public ParserI getParser(String propertie){
        if (propertie.equals("xml")) {
            return new XmlParserImpl();
        }
        else if (propertie.equals("json")) {
            return new JsonParserImpl();
        }
        log.info("Parser was choised");
        return null;
    }
}
