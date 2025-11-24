public class Question {

    public String question;
    public int questionValue;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    public String correctAnswer;

    public Question(String text, int value, String correctAnswer) {
        this.question = text;
        this.questionValue = value;
        this.correctAnswer = correctAnswer;
    }
     
}
