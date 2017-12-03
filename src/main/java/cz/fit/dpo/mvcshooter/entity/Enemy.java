package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Probability;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Enemy extends GameObject {


    private int xCounter = 0;
    private int yCounter = 0;

    private int xDirection;
    private int yDirection;

    private final int xCounterMax = 100;
    private final int yCounterMax = 100;

    private EnemyType enemyType;
    private boolean alive;
    private Missile missileCollided;
    private EnemyStrategy strategy;

    public Enemy(int x, int y, EnemyStrategy strategy) {
        super(x, y);
        alive = true;
        this.strategy = strategy;
        this.xDirection = Probability.plusMinusOneOrZero();
        this.yDirection = Probability.plusMinusOneOrZero();

        if (Probability.oneHalf()) {
            enemyType = EnemyType.ADVANCED;
        } else {
            enemyType = EnemyType.BASIC;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnemy(this);
    }


    public EnemyType getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(EnemyType enemyType) {
        this.enemyType = enemyType;
    }

    public boolean collide(int x, int y) {
        if ((Math.abs(this.x - x) < 30) && (Math.abs(this.y - y) < 30)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void handleCollision() {
        switch (enemyType) {
            case BASIC:
                setAlive(false);
                break;
            case ADVANCED:
                setEnemyType(EnemyType.DAMAGED);
                break;
            case DAMAGED:
                setAlive(false);
                break;
        }
    }

    public void move() {
        if (Probability.oneTo(5)) {
            x = strategy.calculateX(x, xCounter, xDirection);
            if (xCounter < xCounterMax) {
                xCounter++;
            } else {
                xDirection = Probability.plusMinusOneOrZero();
                xCounter = 0;
            }

            y = strategy.calculateY(y, yCounter, yDirection);

            if (yCounter < yCounterMax) {
                yCounter++;
            } else {
                yDirection = Probability.plusMinusOneOrZero();
                yCounter = 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "enemyType=" + enemyType +
                ", alive=" + alive +
                ", x=" + x +
                ", y=" + y +
                '}';
    }


    public Missile getMissileCollided() {
        return missileCollided;
    }

    public void setMissileCollided(Missile missileCollided) {
        this.missileCollided = missileCollided;
    }
}
