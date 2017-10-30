package cz.fit.dpo.mvcshooter.view;

import cz.fit.dpo.mvcshooter.model.StorageModel;
import cz.fit.dpo.mvcshooter.view.ui.Canvas;
import cz.fit.dpo.mvcshooter.view.ui.GraphicsDrawer;
import cz.fit.dpo.mvcshooter.view.ui.MainWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.KeyListener;

/**
 * @author Samuel Butta
 */
public class MainView implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(MainWindow.class);

    private StorageModel model;

    private GraphicsDrawer drawer;
    private MainWindow mainWindow;
    private Canvas canvas;


    public MainView(StorageModel model) {
        this.drawer = new GraphicsDrawer();
        this.canvas = new Canvas(drawer, 0, 0, MainWindow.WINDOW_WIDTH, MainWindow.WINDOW_HEIGHT);
        this.mainWindow = new MainWindow(canvas);

        this.model = model;
        canvas.setCannon(model.getCannon());
    }

    public void setKeyListener(KeyListener keyListener) {
        this.mainWindow.addKeyListener(keyListener);
    }

    @Override
    public void update() {
        logger.info("View updated.");
        canvas.forceRepaint();
    }
}
