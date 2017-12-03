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
            case KeyEvent.VK_SPACE:
                model.missilePressed();
                break;
            case KeyEvent.VK_LEFT:
                model.rotateCannonLeft();
                break;
            case KeyEvent.VK_RIGHT:
                model.rotateCannonRight();
                break;
            case KeyEvent.VK_R:
                model.setRealisticStrategy();
                break;
            case KeyEvent.VK_S:
                model.setSimpleStrategy();
                break;
            case KeyEvent.VK_F2:
                model.saveMemento();
                break;
            case KeyEvent.VK_F3:
                model.loadMemento();
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
