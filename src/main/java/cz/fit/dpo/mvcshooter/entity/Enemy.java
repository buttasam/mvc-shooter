package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.helper.Probability;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Enemy extends GameObject {

    private boolean upgraded;

    public Enemy(int x, int y) {
        super(x, y);
        if(Probability.oneHalf()) {
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
}
