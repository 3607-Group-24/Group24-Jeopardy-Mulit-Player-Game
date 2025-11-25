public class GameOffState implements IGameState {
    
    @Override
    public void startGame(Game game) {
        game.startGame();
    }

    @Override
    public void endGame(Game game) {
        // Game is already off; no action needed
    }

    @Override
    public void processSelection(Game game, Category category, int value) {
        // Cannot process selection when game is off
    }

    @Override
    public void processAnswer(Game game, String answer) {
        // Cannot process answer when game is off
    }
    
}
