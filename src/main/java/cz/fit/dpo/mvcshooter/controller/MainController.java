package cz.fit.dpo.mvcshooter.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by samik on 30.10.17.
 */
public class MainController extends KeyAdapter {


    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        System.out.println("key pressed: " + e.getKeyChar());

    }
}
