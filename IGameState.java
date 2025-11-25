public interface IGameState {

    public void startGame(Game game);
    public void endGame(Game game);
    public void processSelection(Game game, Category category, int value);
    public void processAnswer(Game game, String answer);
    

    
}
