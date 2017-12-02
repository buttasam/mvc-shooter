package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 *
 * Reprezentace strely.
 *
 * @author Samuel Butta
 */
public class Missile extends GameObject {

    public Missile(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
