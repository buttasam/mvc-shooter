package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Probability;
import cz.fit.dpo.mvcshooter.model.strategy.enemy.EnemyStrategy;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Enemy extends GameObject {

    private EnemyType enemyType;
    private boolean alive;
    private Missile missileCollided;
    private EnemyStrategy strategy;

    public Enemy(int x, int y, EnemyStrategy strategy) {
        super(x, y);
        alive = true;
        this.strategy = strategy;

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
        x = strategy.calculateX(x);
        y = strategy.calculateY(y);
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
