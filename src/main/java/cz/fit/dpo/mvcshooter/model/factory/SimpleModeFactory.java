package cz.fit.dpo.mvcshooter.model.factory;

import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.MissileStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.SimpleMissileStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.StaticEnemyStrategy;

/**
 * @author Samuel Butta
 */
public class SimpleModeFactory implements AbstractModeFactory {

    public SimpleModeFactory() {
    }

    @Override
    public MissileStrategy createMissileStrategy() {
        return new SimpleMissileStrategy();
    }

    @Override
    public EnemyStrategy createEnemyStrategy() {
        return new StaticEnemyStrategy();
    }
}
