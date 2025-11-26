import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoadCSV implements QuestionLoader{

    @Override
    public Map<String, Category> loadQuestions(String filePath){
        Map<String, Category> categoryMap = new HashMap<>();
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isHeader = true;

            while((line = br.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); 

                if(values.length < 8) 
                    continue; 

                String catName = values[0].trim();
                int pointValue = Integer.parseInt(values[1].trim());
                String questionText = values[2].trim();
                String optA = values[3].trim();
                String optB = values[4].trim();
                String optC = values[5].trim();
                String optD = values[6].trim();
                String correct = values[7].trim();

                Question q = new Question(catName, pointValue, questionText, optA, optB, optC, optD, correct);

                categoryMap.putIfAbsent(catName, new Category(catName));
                categoryMap.get(catName).addQuestion(q);
            }
        }catch(IOException | NumberFormatException e){
            System.err.println("Error loading CSV: " + e.getMessage());
        }

        return categoryMap;
    }
}