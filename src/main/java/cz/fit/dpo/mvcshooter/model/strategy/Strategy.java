package cz.fit.dpo.mvcshooter.model.strategy;

/**
 * @author Samuel Butta
 */
public interface Strategy {

    public int calculateX(int startX, int angle, double speed, double time);

    public int calculateY(int startY, int angle, double speed, double time);

}
