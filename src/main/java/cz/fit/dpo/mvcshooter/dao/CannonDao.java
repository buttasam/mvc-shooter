package cz.fit.dpo.mvcshooter.dao;

import cz.fit.dpo.mvcshooter.entity.Cannon;

/**
 * @author Samuel Butta
 */
public class CannonDao {


    public void moveDown(Cannon cannon) {
        cannon.setY(cannon.getY() - 1);
    }

    public void moveUp(Cannon cannon) {
        cannon.setY(cannon.getY() + 1);
    }

}
