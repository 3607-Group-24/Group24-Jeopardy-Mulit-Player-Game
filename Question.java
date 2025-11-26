public class Question{
    private String category;
    private int value;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    public Question(String category, int value, String question, String optionA, String optionB, String optionC, String optionD, String correctAnswer){
        this.category = category;
        this.value = value;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public String getCategory(){return category;}
    public int getValue(){return value;}
    public String getQuestionText(){return question;}
    public String getOptionA(){return optionA;}
    public String getOptionB(){return optionB;}
    public String getOptionC(){return optionC;}
    public String getOptionD(){return optionD;}
    public String getCorrectAnswer(){return correctAnswer;}
    
    public boolean checkAnswer(String answer){
        return answer != null && answer.equalsIgnoreCase(correctAnswer);
    }

    @Override
    public String toString(){
        return question + " ($" + value + ")";
    }
}
