package XmlDom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("misc.xml"));

        Element element = document.getDocumentElement();
        System.out.println(element.getTagName());

        System.out.println();

        printElements(element.getChildNodes(), 0);
    }

    static void printElements(NodeList nodeList, int tabs) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if(nodeList.item(i) instanceof Element) {
                System.out.println(getTab(tabs) + ((Element) nodeList.item(i)).getTagName());
                if(((Element) nodeList.item(i)).hasAttribute("name")) {
                    System.out.println(((Element) nodeList.item(i)).getAttribute("name"));
                }
                if(nodeList.item(i).hasChildNodes()) {
                    printElements(nodeList.item(i).getChildNodes(), ++ tabs);
                }
            }
        }
    }
    static String getTab(int tabs) {
        String str = "";
        for (int i = 0; i < tabs ; i++) {
            str += "\t";
        }
        return str;
    }
}
