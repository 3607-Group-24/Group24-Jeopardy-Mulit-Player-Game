public class Player{
    private IScoreStrategy scoringStrategy;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int questionValue, boolean isCorrect) {
        this.score = this.score + questionValue * scoringStrategy.calculateScore(this.score, questionValue, isCorrect);
    }


}
