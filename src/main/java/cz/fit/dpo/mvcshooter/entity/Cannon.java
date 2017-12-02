package cz.fit.dpo.mvcshooter.entity;

/**
 * @author Samuel Butta
 */
public class Cannon extends GameObject {

    private int speed = 3;


    public Cannon(int x, int y) {
        super(x, y);
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

}
