import java.util.List;
public class ScoreBoard implements IGameObserver {
    
    private List<Player> players;
    
    public ScoreBoard(List<Player> players) {
        this.players = players;
    }
    
    @Override
    public void update() {
        displayScores();
    }
    
    private void displayScores() {
        System.out.println("Current Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
    

}
