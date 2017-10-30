package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.view.ui.Canvas;
import cz.fit.dpo.mvcshooter.view.ui.GraphicsDrawer;
import cz.fit.dpo.mvcshooter.view.ui.MainWindow;

/**
 * Created by samik on 30.10.17.
 */
public class MainView {

    private GraphicsDrawer drawer;
    private MainWindow mainWindow;
    private Canvas canvas;


    public MainView() {
        GraphicsDrawer drawer = new GraphicsDrawer();
        canvas = new Canvas(drawer, 0, 0, 500, 500);
        MainWindow mainWindow = new MainWindow(canvas);
    }
}
