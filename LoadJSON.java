import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadJSON implements QuestionLoader{

    @Override
    public Map<String, Category> loadQuestions(String filePath){
        Map<String, Category> categoryMap = new HashMap<>();

        try{
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            
            content = content.trim();
            if(content.startsWith("[")) content = content.substring(1);
            if(content.endsWith("]")) content = content.substring(0, content.length() - 1);

            String[] objects = content.split("\\},\\s*\\{");

            for(String obj : objects){
                String catName = extractValue(obj, "Category");
                int pointValue = Integer.parseInt(extractValue(obj, "Value"));
                String questionText = extractValue(obj, "Question");
                
                String optA = extractValue(obj, "A");
                String optB = extractValue(obj, "B");
                String optC = extractValue(obj, "C");
                String optD = extractValue(obj, "D");
                String correct = extractValue(obj, "CorrectAnswer");

                Question q = new Question(catName, pointValue, questionText, optA, optB, optC, optD, correct);

                categoryMap.putIfAbsent(catName, new Category(catName));
                categoryMap.get(catName).addQuestion(q);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return categoryMap;
    }

    private String extractValue(String source, String key){
        Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*\"?([^,\"}]+)\"?");
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()){
            return matcher.group(1).trim();
        }
        return "";
    }
}