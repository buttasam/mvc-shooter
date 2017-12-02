package cz.fit.dpo.mvcshooter.model.visitor;

import cz.fit.dpo.mvcshooter.entity.Cannon;

import java.awt.*;

/**
 * @author Samuel Butta
 */
public interface Visitor {

    public void visitCannon(Cannon cannon);

}
