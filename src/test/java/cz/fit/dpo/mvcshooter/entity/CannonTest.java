package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.state.DoubleShootingState;
import cz.fit.dpo.mvcshooter.model.state.SingleShootingState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class CannonTest {

    @Test
    public void moveUp() throws Exception {
        Cannon cannon = new Cannon(10, 20, 0);
        cannon.moveUp();
        Assert.assertEquals(20 - cannon.getSpeed(), cannon.getY());
    }

    @Test
    public void rotateLeft() throws Exception {
        Cannon cannon = new Cannon(10, 20, 0);
        cannon.rotateLeft();
        Assert.assertEquals(0 - cannon.getAngleSpeed(), cannon.getAngle());

    }

    @Test
    public void changeState() throws Exception {
        Cannon cannon = new Cannon(10, 20, 0);
        Assert.assertTrue(cannon.getCannonState() instanceof SingleShootingState);

        cannon.changeState();
        Assert.assertTrue(cannon.getCannonState() instanceof DoubleShootingState);
    }

}