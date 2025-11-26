import java.util.Map;

public interface QuestionLoader{

    Map<String, Category> loadQuestions(String filePath);

}