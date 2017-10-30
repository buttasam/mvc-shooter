package cz.fit.dpo.mvcshooter.dao;

import cz.fit.dpo.mvcshooter.entity.Cannon;

/**
 * @author Samuel Butta
 */
public class CannonDao {


    private static final int CANNON_SPEED = 3;

    public void moveDown(Cannon cannon) {
        cannon.setY(cannon.getY() + CANNON_SPEED);
    }

    public void moveUp(Cannon cannon) {
        cannon.setY(cannon.getY() - CANNON_SPEED);
    }

}
