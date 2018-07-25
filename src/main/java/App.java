import dao.PropertieFileReader;
import factory.ChoiseParser;
import org.apache.log4j.Logger;
import parser.ParserI;
import parserImpl.User;

import javax.jws.soap.SOAPBinding;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    private static final Logger log = Logger.getLogger(String.valueOf(App.class));
    public static void main(String[] args) {


        PropertieFileReader propertieFileReader = new PropertieFileReader();

        ChoiseParser choiseParser = new ChoiseParser();
        ParserI parser = choiseParser.getParser(propertieFileReader.getParserType());

        List<User> users = parser.parser();
        users.toString();
        System.out.println();
        log.info("Show collection from User list");


        users.sort(Comparator.comparing(User::getFirstName));
        System.out.println("Sorted collection by firstName");
        users.forEach(user -> System.out.println(user));
        log.info("Show collection sorted by firstName from User list");

        System.out.println();
        users.sort(Comparator.comparing(User::getLastName));
        System.out.println("Sorted collection by lastName");
        users.forEach(user -> System.out.println(user));
        log.info("Show collection sorted by lastName from User list");

        System.out.println();
        users.sort(Comparator.comparing(User::getAge));
        System.out.println("Sorted collection by age");
        users.forEach(user -> System.out.println(user));
        log.info("Show collection sorted by age from User list");

        System.out.println();
        System.out.println("Show element collection by given firstName");
        users.stream().filter(c -> c.getFirstName().equals("Andrei")).collect(Collectors.toList()).forEach(user -> System.out.println(user));
        System.out.println();
        log.info("Show element collection consist of firstName equal smth");

        System.out.println();
        System.out.println("Show element collection by given age");
        users.stream().filter(c -> c.getAge() == 23).collect(Collectors.toList()).forEach(user -> System.out.println(user));
        log.info("Show element collection consist of age equal smth");








    }

}
