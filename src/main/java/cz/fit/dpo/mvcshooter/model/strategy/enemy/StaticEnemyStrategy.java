package cz.fit.dpo.mvcshooter.model.strategy.enemy;

/**
 * @author Samuel Butta
 */
public class StaticEnemyStrategy implements EnemyStrategy {
    @Override
    public int calculateX(int x) {
        return x;
    }

    @Override
    public int calculateY(int y) {
        return y;
    }
}
