package cz.fit.dpo.mvcshooter.model.strategy.enemy;

/**
 * @author Samuel Butta
 */
public class StaticEnemyStrategy implements EnemyStrategy {

    @Override
    public int calculateX(int x, int xCounter, int xDirection) {
        return x;
    }

    @Override
    public int calculateY(int y, int yCounter, int yDirection) {
        return y;
    }
}
