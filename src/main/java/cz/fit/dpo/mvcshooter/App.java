package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.MainController;
import cz.fit.dpo.mvcshooter.model.StorageModel;
import cz.fit.dpo.mvcshooter.view.MainView;

/**
 * Zakladni spousteci trida
 */
public class App {

    public static void main(String[] args) {
        // creating MVC objects
        MainView view = new MainView();
        StorageModel model = new StorageModel();
        MainController controller = new MainController(model);

        // setting and binding
        model.addObserver(view);
        view.setKeyListener(controller);
    }
}
