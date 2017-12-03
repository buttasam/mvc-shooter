package cz.fit.dpo.mvcshooter.model.strategy.enemy;

/**
 * @author Samuel Butta
 */
public interface EnemyStrategy {

    public int calculateX(int x, int xCounter, int xDirection);

    public int calculateY(int y, int yCounter, int yDirection);

}
