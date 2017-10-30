package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.dao.CannonDao;
import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.view.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
public class StorageModel implements Observable {


    /**
     * Stored objects
     */
    private Cannon cannon;


    /**
     * DAOs for entity manipulation
     */
    private CannonDao cannonDao = new CannonDao();


    List<Observer> observers = new ArrayList<>();

    public StorageModel() {
        this.cannon = new Cannon(20, 240);
    }

    public Cannon getCannon() {
        return this.cannon;
    }

    public void moveCannonDown() {
        cannonDao.moveDown(cannon);
    }

    public void moveCannonUp() {
        cannonDao.moveUp(cannon);
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
