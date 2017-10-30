package cz.fit.dpo.mvcshooter.view.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {


    public MainWindow(Canvas canvas) {
        try {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

            this.add(canvas);
            this.pack();
            this.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public void setKeyListener(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "here goes some description...");
    }
}
