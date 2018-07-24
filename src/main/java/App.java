import dao.PropertieFileReader;
import factory.ChoiseParser;
import org.apache.log4j.Logger;
import parser.ParserI;
import parserImpl.User;

import java.util.List;


public class App {
    private static final Logger log = Logger.getLogger(String.valueOf(App.class));
    public static void main(String[] args) {


        PropertieFileReader propertieFileReader = new PropertieFileReader();

        ChoiseParser choiseParser = new ChoiseParser();
        ParserI parser = choiseParser.getParser(propertieFileReader.getParserType());

        List<User> users = parser.parser();
        users.toString();
    }
}
