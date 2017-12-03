package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.model.command.GameCommand;
import cz.fit.dpo.mvcshooter.model.observer.Observer;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class ProxyModel implements Model {

    private Model model;

    public ProxyModel() {
        model = new ModelImpl();
    }

    @Override
    public void loadMemento() {
        model.loadMemento();
    }

    @Override
    public void saveMemento() {
        model.saveMemento();
    }

    @Override
    public void notifyObservers() {
        model.notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        model.addObserver(observer);
    }

    @Override
    public void moveCannonUp() {
        model.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        model.moveCannonDown();
    }

    @Override
    public void missilePressed() {
        model.missilePressed();
    }

    @Override
    public void rotateCannonLeft() {
        model.rotateCannonLeft();
    }

    @Override
    public void rotateCannonRight() {
        model.rotateCannonRight();
    }

    @Override
    public void setRealisticStrategy() {
        model.setRealisticStrategy();
    }

    @Override
    public void setSimpleStrategy() {
        model.setSimpleStrategy();
    }

    @Override
    public void changeCannonState() {
        model.changeCannonState();
    }

    @Override
    public void missileReleased() {
        model.missileReleased();
    }

    @Override
    public void tick() {
        model.tick();
    }

    @Override
    public void tick(GameCommand gameCommand) {
        model.tick(gameCommand);
    }

    @Override
    public List<GameObject> allGameObjects() {
        return model.allGameObjects();
    }

    @Override
    public Cannon getCannon() {
        return model.getCannon();
    }
}
