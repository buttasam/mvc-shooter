package cz.fit.dpo.mvcshooter;

import cz.fit.dpo.mvcshooter.controller.MainController;
import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.view.MainView;

/**
 * Zakladni spousteci trida
 *
 * @author Samuel Butta
 */
public class App {

    public static void main(String[] args) {
        // creating MVC objects
        Model model = new Model();
        MainView view = new MainView(model);
        MainController controller = new MainController(model);

        // setting and binding
        model.addObserver(view);
        view.setKeyListener(controller);
    }
}
