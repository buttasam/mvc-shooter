package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.StorageModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Samuel Butta
 */
public class MainController extends KeyAdapter {


    private StorageModel model;

    public MainController(StorageModel model) {
        this.model = model;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN:
                model.moveCannonDown();
                break;
            default:
        }

        model.notifyObservers();

    }
}