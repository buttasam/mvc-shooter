package cz.fit.dpo.mvcshooter.controller;

import cz.fit.dpo.mvcshooter.model.Model;
import cz.fit.dpo.mvcshooter.model.command.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Samuel Butta
 */
public class MainController extends KeyAdapter {


    private Model model;
    private Queue<GameCommand> commands = new LinkedBlockingQueue<>();

    public MainController(Model model) {
        this.model = model;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                createCommand(new CannonUpCommand());
                break;
            case KeyEvent.VK_DOWN:
                createCommand(new CannonDownCommand());
                break;
            case KeyEvent.VK_SPACE:
                model.missilePressed();
                break;
            case KeyEvent.VK_LEFT:
                createCommand(new CannonRotationLeftCommand());
                break;
            case KeyEvent.VK_RIGHT:
                createCommand(new CannonRotationRightCommand());
                break;
            case KeyEvent.VK_R:
                createCommand(new RealisticStrategyCommand());
                break;
            case KeyEvent.VK_S:
                createCommand(new SimpleStrategyCommand());
                break;
            case KeyEvent.VK_BACK_SPACE:
                model.loadMemento();
                break;
            case KeyEvent.VK_SHIFT:
                createCommand(new ChangeCannonCommand());
                break;
            default:
        }

        model.notifyObservers();

    }

    public void createCommand(GameCommand command) {
        commands.add(command);
        model.saveMemento();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                createCommand(new ShootCommand());
                break;
            default:
        }
    }

    public void mainLoop() throws InterruptedException {

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (commands.isEmpty()) {
                    model.tick();
                } else {
                    model.tick(commands.poll());
                }

            }
        }, 0, 1000 / 120);

    }
}
