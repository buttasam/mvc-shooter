package cz.fit.dpo.mvcshooter.view.ui;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import cz.fit.dpo.mvcshooter.entity.GameObject;
import cz.fit.dpo.mvcshooter.model.Model;

import javax.swing.*;
import java.awt.*;

/**
 * @author Samuel Butta
 */
public class Canvas extends JPanel {

    private GraphicsDrawer drawer;

    private Cannon cannon;

    private Model model; // TODO model proxy

    public Canvas(Model model, GraphicsDrawer drawer, int x, int y, int width, int height) {
        this.model = model;
        this.drawer = drawer;
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }
    
    public void forceRepaint() {
        repaint();
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(GameObject gameObject : model.allGameObjects()) {
            drawer.drawGameObject(g, gameObject);
        }
    }
    
}
