package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.view.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class Model implements Observable {


    /**
     * Stored objects
     */
    private Cannon cannon;


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
        observers.forEach(o -> {
            o.update();
        });
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}
