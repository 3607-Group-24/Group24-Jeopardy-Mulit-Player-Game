public class WrongFinalJeopardy implements ScoreStrategy{
    
    @Override
    public int calculateScore(int currentScore, int wager){
        return currentScore - wager;
    }

}