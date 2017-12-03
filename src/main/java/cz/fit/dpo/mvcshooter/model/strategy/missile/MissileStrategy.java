package cz.fit.dpo.mvcshooter.model.strategy.missile;

/**
 * @author Samuel Butta
 */
public interface MissileStrategy {

    public int calculateX(int startX, int angle, double speed, double time);

    public int calculateY(int startY, int angle, double speed, double time);

}
