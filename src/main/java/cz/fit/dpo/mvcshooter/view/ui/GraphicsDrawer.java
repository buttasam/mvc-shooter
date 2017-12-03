package cz.fit.dpo.mvcshooter.view.ui;

import cz.fit.dpo.mvcshooter.entity.*;
import cz.fit.dpo.mvcshooter.model.helper.Info;
import cz.fit.dpo.mvcshooter.model.helper.Probability;
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

    @Override
    public void visitEnemy(Enemy enemy) {
        switch (enemy.getEnemyType()) {
            case BASIC:
                this.drawImage = enemyImage1;
                break;
            case ADVANCED:
                this.drawImage = enemyImage2;
                break;
            case DAMAGED:
                this.drawImage = collisionImage;
                break;
        }
    }

    public void drawGameObject(Graphics g, GameObject gameObject) {
        gameObject.accept(this);

        g.drawImage(drawImage,
                gameObject.getX() - drawImage.getWidth() / 2,
                gameObject.getY() - drawImage.getHeight() / 2, null);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + Info.score, 5, 20);
        g.drawString("Speed: " + Info.currentSpeed, 130, 20);
        g.drawString("Strategy: " + Info.strategy, 260, 20);

        // for smooth rendering
        Toolkit.getDefaultToolkit().sync();
    }
}
