package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.entity.Missile;
import cz.fit.dpo.mvcshooter.view.Observer;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
public class Model implements Observable {


    /**
     * Stored objects
     */
    private Cannon cannon;
    private List<Missile> missiles = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();


    private Missile currentMissile;
    int fpsCounter = 0;


    List<Observer> observers = new ArrayList<>();

    public Model() {
        this.cannon = new Cannon(20, 240);
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    public void moveCannonDown() {
        cannon.moveDown();
    }

    public void moveCannonUp() {
        cannon.moveUp();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }


    public List<GameObject> allGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();

        gameObjects.add(cannon);
        gameObjects.addAll(missiles);
        gameObjects.addAll(enemies);

        return gameObjects;
    }

    public void missilePressed() {
        if (currentMissile != null) {
            currentMissile.increaseSpeed();
        } else {
            Random r = new Random();
            currentMissile = new Missile(cannon.getX(), cannon.getY());
        }
    }

    public void missileReleased() {
        missiles.add(currentMissile);
        currentMissile = null;
    }


    public List<Missile> getMissiles() {
        return missiles;
    }

    public void tick() {
        tickCount();
        missiles.forEach(Missile::move);
        addRandomEnemy(fpsCounter);
        notifyObservers();
        cleanUp();
    }

    private void tickCount() {
        fpsCounter++;
        if (fpsCounter == Integer.MAX_VALUE) {
            fpsCounter = 0;
        }
    }


    private void cleanUp() {
        removeMissiles();
    }

    private void removeMissiles() {
        if (missiles.size() >= 50) {
            List<Missile> missileToRemove = missiles.stream().filter(m -> m.isOutOfWindow()).collect(Collectors.toList());
            missiles.removeAll(missileToRemove);
        }
    }

    private void addRandomEnemy(int fpsCounter) {
        Random r = new Random();

        if ((r.nextInt(10) % 3 == 0) && fpsCounter % 100 == 0) {

            Enemy enemy = new Enemy(r.nextInt(WindowConfig.WINDOW_WIDTH), r.nextInt(WindowConfig.WINDOW_WIDTH));
            enemies.add(enemy);
        }
    }

}
