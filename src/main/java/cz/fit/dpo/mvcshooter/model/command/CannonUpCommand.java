package cz.fit.dpo.mvcshooter.model.command;

import cz.fit.dpo.mvcshooter.model.Model;

/**
 * @author Samuel Butta
 */
public class CannonUpCommand implements GameCommand {

    @Override
    public void execute(Model model) {
        model.moveCannonUp();
    }

}
