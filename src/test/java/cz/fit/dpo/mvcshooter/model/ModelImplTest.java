package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
@RunWith(MockitoJUnitRunner.class)
public class ModelImplTest {

    @InjectMocks
    private ModelImpl model;

    @Mock
    private Cannon cannon;


    @Test
    public void testMoveCannonUp() {
        model.moveCannonUp();
        Mockito.verify(cannon).moveUp();
    }

}