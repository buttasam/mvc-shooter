package cz.fit.dpo.mvcshooter.view.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Samuel Butta
 */
public class MainWindow extends JFrame {

    private static final String TITLE = "Shooter 0.1";

    public static final int WINDOW_HEIGHT = 500;
    public static final int WINDOW_WIDTH = 500;


    public MainWindow(Canvas canvas) {
        try {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle(TITLE);
            this.setResizable(false);

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((int) (dimension.getWidth() / 2 - 250), (int) (dimension.getHeight() / 2 - 250));

            this.add(canvas);
            this.pack();
            this.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

}
