public class WrongDoubleJeopardy implements ScoreStrategy{
    
    @Override
    public int calculateScore(int currentScore, int questionValue){
        return currentScore - (questionValue * 2);
    }

}
