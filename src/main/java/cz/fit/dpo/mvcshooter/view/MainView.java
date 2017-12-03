package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.observer.Observer;
import cz.fit.dpo.mvcshooter.view.ui.Canvas;
import cz.fit.dpo.mvcshooter.view.ui.GraphicsDrawer;
import cz.fit.dpo.mvcshooter.view.ui.MainWindow;
import cz.fit.dpo.mvcshooter.view.ui.WindowConfig;

import java.awt.event.KeyListener;

/**
 * @author Samuel Butta
 */
public class MainView implements Observer {

    private GraphicsDrawer drawer;
    private MainWindow mainWindow;
    private Canvas canvas;


    public MainView(Model model) {
        this.drawer = new GraphicsDrawer();
        this.canvas = new Canvas(model, drawer, 0, 0, WindowConfig.WINDOW_WIDTH, WindowConfig.WINDOW_HEIGHT);
        this.mainWindow = new MainWindow(canvas);

        canvas.setCannon(model.getCannon());
    }

    public void setKeyListener(KeyListener keyListener) {
        this.mainWindow.addKeyListener(keyListener);
    }

    @Override
    public void update() {
        canvas.forceRepaint();
    }
}
