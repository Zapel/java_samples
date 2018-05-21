package XmlDom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MainDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("misc.xml"));

        Element element = document.getDocumentElement();
        printElements(element.getChildNodes());

    }

    static void printElements(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {

            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            for (int j = 0; j < attributes.getLength() ; j++) {
                Node attribute = attributes.item(j);
                String name = attribute.getNodeName();
                String val = attribute.getNodeValue();
                System.out.println("Attributes - " + name + " = " + val);
            }
            if(nodeList.item(i).hasChildNodes()) {
                printElements(nodeList.item(i).getChildNodes());
            }
        }
    }
}
