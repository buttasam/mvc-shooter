package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.state.CannonState;
import cz.fit.dpo.mvcshooter.model.state.DoubleShootingState;
import cz.fit.dpo.mvcshooter.model.state.SingleShootingState;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Cannon extends GameObject {

    private int speed = 3;

    private int angle;

    private CannonState cannonState;


    public Cannon(int x, int y, int angle) {
        super(x, y);
        this.angle = angle;
        cannonState = new SingleShootingState();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }


    public void rotateLeft() {
        if (angle > -90) {
            angle -= 1;
        }
    }

    public void rotateRight() {
        if (angle < 90) {
            angle += 1;
        }
    }

    public int getAngle() {
        return angle;
    }

    public CannonState getCannonState() {
        return cannonState;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCannon(this);
    }

    public void changeState() {
        if (cannonState instanceof SingleShootingState) {
            cannonState = new DoubleShootingState();
        } else if (cannonState instanceof DoubleShootingState) {
            cannonState = new SingleShootingState();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
