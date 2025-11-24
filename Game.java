import java.util.List;
import java.util.Map;

public class Game {
    
    private QuestionLoader currentLoader;
    private List<Player> players;
    private List<IGameObserver> observers;
    public Map<Category, Question> GameBoard;



    public Game(QuestionLoader loader, List<Player> players) {
        currentLoader = loader;
        this.players = players;
    }

    public void attachObserver(IGameObserver observer){
        observers.add(observer);
        
    }

    public void notifyObserver(GameEvent event){
        for(IGameObserver observer : observers){
            observer.update();
        }
    }






}
