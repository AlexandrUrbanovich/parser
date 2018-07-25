package parserImpl.xmlParserImpl;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.ParserI;
import parserImpl.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class XmlParserImpl implements ParserI {

    private static final Logger log = Logger.getLogger(String.valueOf(XmlParserImpl.class));

    @Override
    public List<User> parser() {
        List<User> users = new ArrayList<>();
        try{
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resources/users.xml");
            Node roote = document.getDocumentElement();

            NodeList userss = ((Element) roote).getElementsByTagName("user");

            for (int i = 0; i < userss.getLength(); i++) {
                Node persons = userss.item(i);

                if(Node.ELEMENT_NODE == persons.getNodeType()) {
                    Element element = (Element) persons;
                    String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                    Integer age = Integer.valueOf( element.getElementsByTagName("age").item(0).getTextContent());

                    User currentUser = new User(firstName, lastName, age);
                    users.add(currentUser);

                    log.info("In User was added data from XML file");
                }

            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        log.info("Data read from users.xml");

        System.out.println("List");
        for (User person : users) {
            System.out.println(person);
        }

        return users;
    }
}
