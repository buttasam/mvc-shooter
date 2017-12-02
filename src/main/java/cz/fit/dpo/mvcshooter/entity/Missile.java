package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.visitor.Visitor;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;

/**
 * Reprezentace strely.
 *
 * @author Samuel Butta
 */
public class Missile extends GameObject {

    private int speed = 1;

    private double angle = 30;

    private static final int SPEED_LIMIT = 30;

    public Missile(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMissile(this);
    }

    public void increaseSpeed() {
        if (speed < SPEED_LIMIT) {
            speed += 1;
        }
    }

    public void move() {
        x = x + speed;
    }

    @Override
    public String toString() {
        return "Missile{" +
                "speed=" + speed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean isOutOfWindow() {
        if(x < 0 || y < 0 || x > WindowConfig.WINDOW_WIDTH || y > WindowConfig.WINDOW_HEIGHT) {
            return true;
        } else {
            return false;
        }
    }
}
