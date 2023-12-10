import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLFileReader implements FileReaderStrategy {

    public List<String[]> readFile(String filePath) {
        List<String[]> cardInfoList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList cardList = document.getElementsByTagName("CARD");

            for (int i = 0; i < cardList.getLength(); i++) {
                Element cardElement = (Element) cardList.item(i);
                String cardNumber = cardElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                String expirationDate = cardElement.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                String cardHolderName = cardElement.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();

                cardInfoList.add(new String[]{cardNumber, expirationDate, cardHolderName});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cardInfoList;
    }

    
    public void writeFile(List<String[]> output, String outputPath) {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
    
        try {
            documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
    
            // Root element <CARDS>
            Element root = document.createElement("CARDS");
            document.appendChild(root);
    
            for (String[] cardData : output) {
                // <CARD> element
                Element cardElement = document.createElement("CARD");
                root.appendChild(cardElement);
    
                // <CARD_NUMBER> element
                Element cardNumberElement = document.createElement("CARD_NUMBER");
                if (cardData[0] != null && !cardData[0].isEmpty()) {
                    cardNumberElement.appendChild(document.createTextNode(cardData[0]));
                } else {
                    // Add an empty text node to ensure the tag is not self-closing
                    cardNumberElement.appendChild(document.createTextNode(""));
                }
                cardElement.appendChild(cardNumberElement);
    
                // <CARD_TYPE> element
                Element cardTypeElement = document.createElement("CARD_TYPE");
                cardTypeElement.appendChild(document.createTextNode(cardData[1]));
                cardElement.appendChild(cardTypeElement);
            }
    
            // Create Transformer for writing to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // Omit XML declaration
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(outputPath));
    
            // Write data to XML file
            transformer.transform(domSource, streamResult);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
