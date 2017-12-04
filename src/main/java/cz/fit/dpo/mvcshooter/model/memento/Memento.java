package cz.fit.dpo.mvcshooter.model.memento;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.Missile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Samuel Butta
 */
public class Memento {

    private Cannon cannon;
    private List<Missile> missiles = new CopyOnWriteArrayList<>();
    private List<Enemy> enemies = new CopyOnWriteArrayList<>();
    private List<Missile> currentMissiles = new CopyOnWriteArrayList<>();

    public Memento() {
    }


    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }


    public List<Missile> getMissiles() {
        return missiles;
    }

    public void setMissiles(List<Missile> missiles) {
        this.missiles = missiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Missile> getCurrentMissiles() {
        return currentMissiles;
    }

    public void setCurrentMissiles(List<Missile> currentMissiles) {
        this.currentMissiles = currentMissiles;
    }
}
