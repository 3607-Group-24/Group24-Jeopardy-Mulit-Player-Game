import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadXML implements QuestionLoader{

    @Override
    public Map<String, Category> loadQuestions(String filePath){
        Map<String, Category> categoryMap = new HashMap<>();

        try{
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("QuestionItem");

            for(int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);

                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;

                    String catName = getTagValue("Category", eElement);
                    int pointValue = Integer.parseInt(getTagValue("Value", eElement));
                    String questionText = getTagValue("QuestionText", eElement);
                    
                    String optA = "";
                    String optB = "";
                    String optC = "";
                    String optD = "";
                    
                    Node optionsNode = eElement.getElementsByTagName("Options").item(0);
                    if(optionsNode != null && optionsNode.getNodeType() == Node.ELEMENT_NODE){
                         Element opts = (Element) optionsNode;
                         optA = getTagValue("OptionA", opts);
                         optB = getTagValue("OptionB", opts);
                         optC = getTagValue("OptionC", opts);
                         optD = getTagValue("OptionD", opts);
                    }

                    String correct = getTagValue("CorrectAnswer", eElement);

                    Question q = new Question(catName, pointValue, questionText, optA, optB, optC, optD, correct);

                    categoryMap.putIfAbsent(catName, new Category(catName));
                    categoryMap.get(catName).addQuestion(q);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return categoryMap;
    }

    private String getTagValue(String tag, Element element){
        NodeList nl = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nl.item(0);
        return nValue.getNodeValue().trim();
    }
}
