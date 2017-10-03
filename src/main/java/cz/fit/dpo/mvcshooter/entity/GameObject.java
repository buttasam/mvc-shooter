package cz.fit.dpo.mvcshooter.entity;

/**
 *
 * Zakladni abstraktri trida pro herni objekt.
 *
 * @author Samuel Butta
 */
abstract class GameObject {

    protected int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
