public class CorrectAnswer implements ScoreStrategy{
    
    @Override
    public int calculateScore(int currentScore, int questionValue){
        return currentScore + questionValue;
    }

}