public interface IScoreStrategy {

    int calculateScore(int currentScore, int questionValue, boolean isCorrect);
    
}
