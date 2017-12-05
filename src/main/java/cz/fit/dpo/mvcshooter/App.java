package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.MainController;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.ProxyModel;
import cz.fit.dpo.mvcshooter.view.MainView;

/**
 * Zakladni spousteci trida
 *
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        // creating MVC objects
        Model modelProxy = new ProxyModel();
        MainView view = new MainView(modelProxy);
        MainController controller = new MainController(modelProxy);

        // setting and binding
        modelProxy.addObserver(view);
        view.setKeyListener(controller);

        controller.mainLoop();

    }
}
