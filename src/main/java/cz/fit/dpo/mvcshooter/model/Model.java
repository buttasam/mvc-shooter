package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.model.memento.Originator;
import cz.fit.dpo.mvcshooter.model.observer.Observable;

import java.util.List;

/**
 * @author Samuel Butta
 */
public interface Model extends Observable, Originator {
    void moveCannonUp();

    void moveCannonDown();

    void missilePressed();

    void rotateCannonLeft();

    void rotateCannonRight();

    void setRealisticStrategy();

    void setSimpleStrategy();

    void changeCannonState();

    void missileReleased();

    void tick();

    List<GameObject> allGameObjects();

    Cannon getCannon();
}
