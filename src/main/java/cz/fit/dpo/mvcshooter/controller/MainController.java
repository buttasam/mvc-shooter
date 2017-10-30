package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.StorageModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by samik on 30.10.17.
 */
public class MainController extends KeyAdapter {


    private StorageModel model;

    public MainController(StorageModel model) {
        this.model = model;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println("key pressed: " + e.getKeyChar());
        model.notifyObservers();

    }
}
