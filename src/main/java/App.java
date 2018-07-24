import dao.FileReader;
import factory.ChoiseParser;
import org.apache.log4j.Logger;
import parser.ParserI;


public class App {
    private static final Logger log = Logger.getLogger(String.valueOf(App.class));
    public static void main(String[] args) {


        FileReader fileReader = new FileReader();
        fileReader.readFile();
        System.out.println(fileReader.getStringRepresentation());

        ChoiseParser choiseParser = new ChoiseParser();


        if (fileReader.getStringRepresentation().contains("xml")){
            log.info("Set propertie XML");
            ParserI parserI = choiseParser.getParser("xml");
            System.out.println(parserI);
        }if (fileReader.getStringRepresentation().contains("json")) {
            log.info("Set propertie JSON");
            ParserI parserI = choiseParser.getParser("json");
            System.out.println(parserI);
        }
    }
}
