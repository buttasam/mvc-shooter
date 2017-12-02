package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Probability;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Enemy extends GameObject {

    private boolean upgraded;
    private boolean alive;

    public Enemy(int x, int y) {
        super(x, y);
        alive = true;
        if (Probability.oneHalf()) {
            upgraded = false;
        } else {
            upgraded = true;
        }

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnemy(this);
    }

    public boolean isUpgraded() {
        return upgraded;
    }

    public void setUpgraded(boolean upgraded) {
        this.upgraded = upgraded;
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
}
