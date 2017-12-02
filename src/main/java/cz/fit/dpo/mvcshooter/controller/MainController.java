package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Samuel Butta
 */
public class MainController extends KeyAdapter {


    private Model model;

    public MainController(Model model) {
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
            case KeyEvent.VK_SPACE: {
                model.missilePressed();
            }
                break;
            default:
        }

        model.notifyObservers();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                model.missileReleased();
                System.out.println(model.getMissiles());
                break;
            default:
        }
    }

    public void mainLoop() throws InterruptedException {

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                model.tick();

            }
        }, 0, 1000 / 120);

    }
}
