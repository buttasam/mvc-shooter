package cz.fit.dpo.mvcshooter.model.state;

/**
 * @author Samuel Butta
 */
public class SingleShootingState implements CannonState {

    @Override
    public int numberOfMissiles() {
        return 1;
    }

}
