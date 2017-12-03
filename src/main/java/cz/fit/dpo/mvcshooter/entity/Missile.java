package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Info;
import cz.fit.dpo.mvcshooter.model.strategy.missile.MissileStrategy;
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
    private MissileStrategy missileStrategy;


    private static final int SPEED_LIMIT = 100;

    public Missile(int x, int y, int angle, MissileStrategy missileStrategy) {
        super(x, y);
        this.startX = x;
        this.startY = y;
        this.angle = angle;
        this.missileStrategy = missileStrategy;
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

    public void move() {
        time += 1;
        x = missileStrategy.calculateX(startX, angle, speed, time);
        y = missileStrategy.calculateY(startY, angle, speed, time);
    }

    @Override
    public String toString() {
        return "Missile{" +
                "speed=" + speed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
