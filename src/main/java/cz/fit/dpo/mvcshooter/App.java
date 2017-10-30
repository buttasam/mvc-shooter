package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.MainController;
import cz.fit.dpo.mvcshooter.model.StorageModel;
import cz.fit.dpo.mvcshooter.view.MainView;
import cz.fit.dpo.mvcshooter.view.ui.MainWindow;
import javax.swing.SwingUtilities;

/**
 *
 * Zakladni spousteci trida
 *
 */
public class App {
    
    public static void main(String[] args) {

        MainView view = new MainView();
        MainController controller = new MainController();
        StorageModel model = new StorageModel();

        view.setKeyListener(controller);

    }
}
