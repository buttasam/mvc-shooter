package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Enemy extends GameObject {

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
