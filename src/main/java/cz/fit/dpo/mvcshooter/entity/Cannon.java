package cz.fit.dpo.mvcshooter.entity;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Cannon extends GameObject {


    public Cannon(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return 100;
    }

    public int getY() {
        return 100;
    }
    
}
