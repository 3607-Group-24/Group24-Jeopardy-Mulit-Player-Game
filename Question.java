public class Question {

    public String question;
    public int questionValue;
    public String correctAnswer;

    public Question(String text, int value, String correctAnswer) {
        this.question = text;
        this.questionValue = value;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);

    }
     
}
