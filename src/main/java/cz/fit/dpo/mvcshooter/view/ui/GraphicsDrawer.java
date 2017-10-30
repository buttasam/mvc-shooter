package cz.fit.dpo.mvcshooter.view.ui;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.Missile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Samuel Butta
 */
public class GraphicsDrawer {

    private BufferedImage cannonImage;
    private BufferedImage enemyImage1;
    private BufferedImage enemyImage2;
    private BufferedImage missileImage;
    private BufferedImage collisionImage;


    public GraphicsDrawer() {
        try {
            cannonImage = ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
            enemyImage1 = ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
            enemyImage2 = ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
            missileImage = ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
            collisionImage = ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }


    public void drawCannon(Graphics g, Cannon cannon) {
        g.drawImage(cannonImage,
                cannon.getX() - cannonImage.getWidth() / 2,
                cannon.getY() - cannonImage.getHeight() / 2, null);
    }

    public void drawMissile(Graphics g, Missile missile) {

    }

    public void drawEnemy(Graphics g, Enemy enemy) {

    }

}
