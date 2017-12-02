package cz.fit.dpo.mvcshooter.entity;

import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

/**
 * @author Samuel Butta
 */
public class Cannon extends GameObject {

    private int speed = 3;

    private int angle;


    public Cannon(int x, int y, int angle) {
        super(x, y);
        this.angle = angle;
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
        if(angle > - 90) {
            angle -= 1;
        }
    }

    public void rotateRight() {
        if(angle < 90) {
            angle += 1;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCannon(this);
    }
}
