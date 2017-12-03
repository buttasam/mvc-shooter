package cz.fit.dpo.mvcshooter.model.strategy.missile;

import java.io.Serializable;

/**
 * @author Samuel Butta
 */
public interface MissileStrategy extends Serializable {

    public int calculateX(int startX, int angle, double speed, double time);

    public int calculateY(int startY, int angle, double speed, double time);

}
