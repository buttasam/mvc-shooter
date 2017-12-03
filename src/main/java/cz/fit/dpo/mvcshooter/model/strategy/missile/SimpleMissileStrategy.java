package cz.fit.dpo.mvcshooter.model.strategy.missile;

/**
 * @author Samuel Butta
 */
public class SimpleMissileStrategy implements MissileStrategy {

    @Override
    public int calculateX(int startX, int angle, double speed, double time) {
        double radians = Math.toRadians(angle);

        return (int) ((startX + (speed) * time * Math.cos(radians)));
    }

    @Override
    public int calculateY(int startY, int angle, double speed, double time) {
        double radians = Math.toRadians(angle);

        return (int) ((startY + (speed) * time * Math.sin(radians)) + 0.01 * (time * time));
    }

}
