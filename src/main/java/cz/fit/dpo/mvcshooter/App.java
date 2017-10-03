package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.view.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * Zakladni spousteci trida
 *
 */
public class App {
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(() ->  new MainWindow().setVisible(true));
    }
}
