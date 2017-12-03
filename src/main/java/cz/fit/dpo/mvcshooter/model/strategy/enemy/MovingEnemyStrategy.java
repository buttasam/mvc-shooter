package cz.fit.dpo.mvcshooter.model.strategy.enemy;

import cz.fit.dpo.mvcshooter.model.helper.Probability;

import java.io.Serializable;

/**
 * @author Samuel Butta
 */
public class MovingEnemyStrategy implements EnemyStrategy, Serializable {


    @Override
    public int calculateX(int x, int xCounter, int xDirection) {

        return x + xDirection;
    }

    @Override
    public int calculateY(int y, int yCounter, int yDirection) {
        return y + yDirection;
    }

}
