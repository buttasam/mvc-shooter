package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.visitor.Visitable;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;

import java.io.Serializable;

/**
 * Zakladni abstraktri trida pro herni objekt.
 *
 * @author Samuel Butta
 */
public class GameObject implements Visitable, Serializable {

    protected int x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void accept(Visitor visitor) {
    }

    public boolean isOutOfWindow() {
        if (x < 0 || y < 0 || x > WindowConfig.WINDOW_WIDTH || y > WindowConfig.WINDOW_HEIGHT) {
            return true;
        } else {
            return false;
        }
    }
}
