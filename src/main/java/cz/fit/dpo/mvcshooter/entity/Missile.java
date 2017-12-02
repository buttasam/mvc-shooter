package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Info;
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
    private double angle = -45 ;

    private static final int SPEED_LIMIT = 100;

    public Missile(int x, int y) {
        super(x, y);
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitMissile(this);
    }

    public void increaseSpeed() {
        if (speed < SPEED_LIMIT) {
            speed += 0.05;
        }
        Info.currentSpeed += 1;
    }

    public void move() {
        time += 1;
        System.out.println(time);

        double radians = Math.toRadians(angle);
        x = (int)((startX + (speed)*time*Math.cos(radians))) ;
        y = (int)(startY + (speed)*time*Math.sin(radians) + (1)*0.01*(time*time));

        System.out.println(x + ":" + y);
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
