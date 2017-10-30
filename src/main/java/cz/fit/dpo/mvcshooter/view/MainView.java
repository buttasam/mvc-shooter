package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.view.ui.Canvas;
import cz.fit.dpo.mvcshooter.view.ui.GraphicsDrawer;
import cz.fit.dpo.mvcshooter.view.ui.MainWindow;

import java.awt.event.KeyListener;

/**
 * Created by samik on 30.10.17.
 */
public class MainView implements Observer {

    private GraphicsDrawer drawer;
    private MainWindow mainWindow;
    private Canvas canvas;


    public MainView() {
        this.drawer = new GraphicsDrawer();
        this.canvas = new Canvas(drawer, 0, 0, 500, 500);
        this.mainWindow = new MainWindow(canvas);
    }

    public void setKeyListener(KeyListener keyListener) {
        this.mainWindow.addKeyListener(keyListener);
    }

    @Override
    public void update() {
        System.out.println("view updated");
    }
}
