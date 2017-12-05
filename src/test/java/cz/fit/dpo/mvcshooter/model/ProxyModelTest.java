package cz.fit.dpo.mvcshooter.model;

import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.StaticEnemyStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

/**
 * @author Samuel Butta
 */
@RunWith(MockitoJUnitRunner.class)
public class ProxyModelTest {

    @InjectMocks
    private ProxyModel proxyModel;

    @Mock
    private Model model;


    @Test
    public void allGameObjects() throws Exception {
        Enemy enemy = new Enemy(10, 10, new StaticEnemyStrategy());

        Mockito.when(model.allGameObjects()).thenReturn(Arrays.asList(enemy));

        Assert.assertEquals(enemy, proxyModel.allGameObjects().get(0));
    }

}