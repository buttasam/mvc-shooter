package cz.fit.dpo.mvcshooter.model.singleton;

/**
 * @author Samuel Butta
 */
public class GameInfo {

    private int score = 0;
    private int currentSpeed = 1;

    private static final GameInfo INSTANCE = new GameInfo();


    private GameInfo() {
        // empty constructor
    }

    public static GameInfo getInstance() {
        return INSTANCE;
    }

    public synchronized void increaseScore() {
        score++;
    }

    public synchronized void increaseCurrentSpeed() {
        currentSpeed++;
    }

    public synchronized void nullCurrentSpeed() {
        currentSpeed = 0;
    }

    public int getScore() {
        return score;
    }

    public synchronized void setScore(int score) {
        this.score = score;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
