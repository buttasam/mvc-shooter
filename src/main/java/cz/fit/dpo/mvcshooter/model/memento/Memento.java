package cz.fit.dpo.mvcshooter.model.memento;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.Missile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class Memento {

    private Cannon cannon;
    private ArrayList<Missile> missiles = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Missile> currentMissiles = new ArrayList<>();

    public Memento() {
    }


    public Cannon getCannon() {
        return cannon;
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }


    public ArrayList<Missile> getMissiles() {
        return missiles;
    }

    public void setMissiles(ArrayList<Missile> missiles) {
        this.missiles = missiles;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<Missile> getCurrentMissiles() {
        return currentMissiles;
    }

    public void setCurrentMissiles(ArrayList<Missile> currentMissiles) {
        this.currentMissiles = currentMissiles;
    }
}
