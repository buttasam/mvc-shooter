package cz.fit.dpo.mvcshooter.model.factory;

import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.strategy.missile.MissileStrategy;

/**
 * @author Samuel Butta
 */
public interface AbstractModeFactory {

    public MissileStrategy createMissileStrategy();

    public EnemyStrategy createEnemyStrategy();

}
