package cz.fit.dpo.mvcshooter.model.factory;

import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.MovingEnemyStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.MissileStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.RealisticMissileStrategy;

/**
 * @author Samuel Butta
 */
public class RealisticModeFactory implements AbstractModeFactory {

    public RealisticModeFactory() {
    }

    @Override
    public MissileStrategy createMissileStrategy() {
        return new RealisticMissileStrategy();
    }

    @Override
    public EnemyStrategy createEnemyStrategy() {
        return new MovingEnemyStrategy();
    }
}
