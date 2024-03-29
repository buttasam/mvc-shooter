package cz.fit.dpo.mvcshooter.model.strategy.missile;

import java.io.Serializable;

/**
 * @author Samuel Butta
 */
public class RealisticMissileStrategy implements MissileStrategy, Serializable {

    private double BALISTIC_COEFFICIENT = 0.003;

    @Override
    public int calculateX(int startX, int angle, double speed, double time) {
        double radians = Math.toRadians(angle);

        return (int) ((startX + (speed) * time * Math.cos(radians)) - BALISTIC_COEFFICIENT * (time * time));
    }

    @Override
    public int calculateY(int startY, int angle, double speed, double time) {
        double radians = Math.toRadians(angle);

        return (int) ((startY + (speed) * time * Math.sin(radians)) + 0.01 * (time * time));
    }

}
