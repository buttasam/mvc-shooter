package cz.fit.dpo.mvcshooter.model.state;

/**
 * @author Samuel Butta
 */
public class DoubleShootingState implements CannonState {

    @Override
    public int numberOfMissiles() {
        return 2;
    }

}
