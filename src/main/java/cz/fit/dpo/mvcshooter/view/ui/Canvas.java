package cz.fit.dpo.mvcshooter.view.ui;

import cz.fit.dpo.mvcshooter.entity.Cannon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author Samuel Butta
 */
public class Canvas extends JPanel {

    private GraphicsDrawer drawer;

    private Cannon cannon;

    public Canvas(GraphicsDrawer drawer, int x, int y, int width, int height) {
        this.drawer = drawer;
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }
    
    public void thisIsHowYouForceGuiToRepaint() {        
        repaint();
    }

    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    
        drawer.drawCannon(g, cannon);
    }
    
}
