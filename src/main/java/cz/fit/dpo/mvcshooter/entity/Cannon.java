package cz.fit.dpo.mvcshooter.entity;

/**
 * @author Samuel Butta
 */
public class Cannon extends GameObject {


    public Cannon(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
