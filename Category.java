import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category{
    private final String categoryName;
    private List<Question> questions;

    public Category(String categoryName){
        this.categoryName = categoryName;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q){
        if (q != null){
            questions.add(q);
        }
    }

    public void removeQuestion(String questionText){
        this.questions = this.questions.stream()
            .filter(q -> !q.getQuestionText().equalsIgnoreCase(questionText))
            .collect(Collectors.toList());
    }

    public String getCategoryName(){
        return categoryName;
    }

    public List<Question> getQuestions(){
        return questions;
    }
}