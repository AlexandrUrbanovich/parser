package parserImpl.xmlParserImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.xmlParser.XmlParserI;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParserImpl implements XmlParserI {

    @Override
    public void parser() {
        List<String> persons = new ArrayList<>();

        try{
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("src/main/resource/users.xml");
            Node roote = document.getDocumentElement();

            NodeList users = roote.getChildNodes();

            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);

                if (user.getNodeType() != Node.TEXT_NODE) {
                    NodeList userProperties =  user.getChildNodes();

                    for (int j = 0; j < userProperties.getLength(); j++) {
                        Node userPropertie = userProperties.item(j);

                        if (userPropertie.getNodeType() != Node.TEXT_NODE) {
                           persons.add(userPropertie.getNodeName() + " : " + userPropertie.getChildNodes().item(0).getTextContent());
                       }
                    }
                }
            }
        }catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }


        System.out.println("List");
        for (String person : persons) {
            System.out.println(person);
        }
    }
}