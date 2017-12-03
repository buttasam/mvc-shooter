package cz.fit.dpo.mvcshooter.model.strategy.enemy;

import cz.fit.dpo.mvcshooter.model.helper.Probability;

import java.io.Serializable;

/**
 * @author Samuel Butta
 */
public class MovingEnemyStrategy implements EnemyStrategy, Serializable {
    @Override
    public int calculateX(int x) {
        return x + Probability.plusMinusOneOrZero();
    }

    @Override
    public int calculateY(int y) {
        return y + Probability.plusMinusOneOrZero();
    }
}
