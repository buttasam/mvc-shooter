package cz.fit.dpo.mvcshooter.view.ui;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.Enemy;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.entity.Missile;
import cz.fit.dpo.mvcshooter.model.visitor.Visitor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Samuel Butta
 */
public class GraphicsDrawer implements Visitor {

    private BufferedImage drawImage;

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


    @Override
    public void visitCannon(Cannon cannon) {
        this.drawImage = cannonImage;
    }

    @Override
    public void visitMissile(Missile missile) {
        this.drawImage = missileImage;
    }

    public void drawGameObject(Graphics g, GameObject gameObject) {
        gameObject.accept(this);

        g.drawImage(drawImage,
                gameObject.getX() - cannonImage.getWidth() / 2,
                gameObject.getY() - cannonImage.getHeight() / 2, null);

        // for smooth rendering
        Toolkit.getDefaultToolkit().sync();
    }
}
