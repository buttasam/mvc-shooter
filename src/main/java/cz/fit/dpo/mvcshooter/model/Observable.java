package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.view.Observer;

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
