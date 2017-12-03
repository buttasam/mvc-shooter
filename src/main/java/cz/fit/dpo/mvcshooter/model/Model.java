package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.entity.Missile;
import cz.fit.dpo.mvcshooter.model.factory.AbstractModeFactory;
import cz.fit.dpo.mvcshooter.model.factory.RealisticModeFactory;
import cz.fit.dpo.mvcshooter.model.helper.Info;
import cz.fit.dpo.mvcshooter.model.helper.Probability;
import cz.fit.dpo.mvcshooter.model.memento.Memento;
import cz.fit.dpo.mvcshooter.model.memento.MementoStorage;
import cz.fit.dpo.mvcshooter.model.memento.Originator;
import cz.fit.dpo.mvcshooter.model.state.CannonState;
import cz.fit.dpo.mvcshooter.model.state.DoubleShootingState;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.MissileStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.RealisticMissileStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.SimpleMissileStrategy;
import cz.fit.dpo.mvcshooter.view.Observer;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;
import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
public class Model implements Observable, Originator {


    /**
     * Stored objects
     */
    private Cannon cannon;
    private ArrayList<Missile> missiles = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Missile> currentMissiles = new ArrayList<>();


    private MissileStrategy missileStrategy;
    private EnemyStrategy enemyStrategy;

    private CannonState cannonState;
    int fpsCounter = 0;


    List<Observer> observers = new ArrayList<>();

    private MementoStorage mementoStorage = new MementoStorage();

    public Model() {
        this.cannon = new Cannon(20, 240, -45);

        AbstractModeFactory factory = new RealisticModeFactory(); // Hardcoded

        this.missileStrategy = factory.createMissileStrategy();
        this.enemyStrategy = factory.createEnemyStrategy();

        this.cannonState = new DoubleShootingState();
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
        if (!currentMissiles.isEmpty()) {
            currentMissiles.forEach(Missile::increaseSpeed);
        } else {
            Info.currentSpeed = 1;
            for (int i = 0; i < cannonState.numberOfMissiles(); i++) {
                currentMissiles.add(new Missile(cannon.getX(), cannon.getY(), cannon.getAngle() / (i + 1), this.missileStrategy));
            }
        }
    }

    public void missileReleased() {
        missiles.addAll(currentMissiles);
        currentMissiles = new ArrayList<>();
    }


    public List<Missile> getMissiles() {
        return missiles;
    }

    public void tick() {
        tickCount();
        missiles.forEach(Missile::move);
        enemies.forEach(Enemy::move);
        checkCollisions();
        removeEnemies();
        addRandomEnemy(fpsCounter);
        notifyObservers();
        cleanUp();
    }

    private void checkCollisions() {

        missiles.forEach(m -> enemies.forEach(e -> {
            if ((e.collide(m.getX(), m.getY())) && e.getMissileCollided() != m) {
                e.handleCollision();
                e.setMissileCollided(m);
                Info.score++;
            }
        }));


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
        List<Missile> missileToRemove = missiles.stream().filter(m -> m.isOutOfWindow()).collect(Collectors.toList());
        missiles.removeAll(missileToRemove);
    }

    public void removeEnemies() {
        List<Enemy> enemiesToDelete = enemies.stream().filter(e -> !e.isAlive()).collect(Collectors.toList());
        enemies.removeAll(enemiesToDelete);
    }


    private void addRandomEnemy(int fpsCounter) {
        Random r = new Random();

        if (Probability.oneThird() && fpsCounter % 100 == 0) {
            Enemy enemy = new Enemy(r.nextInt(WindowConfig.WINDOW_WIDTH), r.nextInt(WindowConfig.WINDOW_WIDTH), enemyStrategy);
            enemies.add(enemy);
        }
    }

    public void rotateCannonLeft() {
        cannon.rotateLeft();
    }

    public void rotateCannonRight() {
        cannon.rotateRight();
    }

    public void setRealisticStrategy() {
        this.missileStrategy = new RealisticMissileStrategy();
        Info.strategy = "Realistic";
    }

    public void setSimpleStrategy() {
        this.missileStrategy = new SimpleMissileStrategy();
        Info.strategy = "Simple";
    }

    @Override
    public void loadMemento() {
        try {
            Memento memento = mementoStorage.lastMemento();
            cannon = memento.getCannon();
            currentMissiles = memento.getCurrentMissiles();
            enemies = memento.getEnemies();
            missiles = memento.getMissiles();

            notifyObservers();
        } catch (EmptyStackException e) {
            System.out.println("No saved memento");
        }
    }

    @Override
    public void saveMemento() {
        Memento memento = new Memento();
        memento.setCannon(SerializationUtils.clone(cannon));
        memento.setCurrentMissiles(SerializationUtils.clone(currentMissiles));
        memento.setEnemies(SerializationUtils.clone(enemies));
        memento.setMissiles(SerializationUtils.clone(missiles));

        mementoStorage.saveMemento(memento);
    }
}
