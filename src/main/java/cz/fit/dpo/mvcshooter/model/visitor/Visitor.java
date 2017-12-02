package cz.fit.dpo.mvcshooter.model.visitor;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.Missile;

import java.awt.*;

/**
 * @author Samuel Butta
 */
public interface Visitor {

    public void visitCannon(Cannon cannon);

    public void visitMissile(Missile missile);

    public void visitEnemy(Enemy enemy);
}
