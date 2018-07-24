import dao.FileReader;
import factory.ChoiseParser;
import parser.ParserI;


public class App {
    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        fileReader.readFile();
        System.out.println(fileReader.getStringRepresentation());

        ChoiseParser choiseParser = new ChoiseParser();


        if (fileReader.getStringRepresentation().contains("xml")){
            System.out.println("xml");
            ParserI parserI = choiseParser.getParser("xml");
            System.out.println(parserI);
        }if (fileReader.getStringRepresentation().contains("json")) {
            System.out.println("json");
            choiseParser.getParser("json");
            ParserI parserI = choiseParser.getParser("json");
            System.out.println(parserI);
        }


    }
}
