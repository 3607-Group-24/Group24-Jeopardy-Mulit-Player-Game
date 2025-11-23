public interface ScoreStrategy {

    int calculateScore(int currentScore, int questionValue, boolean isCorrect);
    
}
