package cz.fit.dpo.mvcshooter.model.observer;

import cz.fit.dpo.mvcshooter.model.observer.Observer;

/**
 * @author Samuel Butta
 */
public interface Observable {

    /**
     * notify all observers that state has changed
     */
    public void notifyObservers();

    public void addObserver(Observer observer);
}
