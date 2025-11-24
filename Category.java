import java.util.List;

public class Category {
    
    private String CategroyName;
    private List<Question> questions;

    public Category(String name) {
        this.CategroyName = name;
    }

    public String getCategroyName() {
        return CategroyName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestions(List<Question> question) {
        questions.addAll(question);
    }

    public void removeQuestions(List<Question> question){
        questions.removeAll(question);
        
    }

}
