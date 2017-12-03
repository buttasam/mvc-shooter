package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Info;
import cz.fit.dpo.mvcshooter.model.strategy.Strategy;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;

/**
 * Reprezentace strely.
 *
 * @author Samuel Butta
 */
public class Missile extends GameObject {

    private final int startX;
    private final int startY;
    private double speed = 1;
    private double time = 0;
    private int angle;


    private static final int SPEED_LIMIT = 100;

    public Missile(int x, int y, int angle) {
        super(x, y);
        this.startX = x;
        this.startY = y;
        this.angle = angle;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMissile(this);
    }

    public void increaseSpeed() {
        if (speed < SPEED_LIMIT) {
            speed += 0.05;
            Info.currentSpeed += 1;
        }
    }

    public void move(Strategy strategy) {
        time += 1;
        x = strategy.calculateX(startX, angle, speed, time);
        y = strategy.calculateY(startY, angle, speed, time);
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
        if (x < 0 || y < 0 || x > WindowConfig.WINDOW_WIDTH || y > WindowConfig.WINDOW_HEIGHT) {
            return true;
        } else {
            return false;
        }
    }
}
