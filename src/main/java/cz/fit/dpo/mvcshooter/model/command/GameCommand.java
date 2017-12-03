package cz.fit.dpo.mvcshooter.model.command;

import cz.fit.dpo.mvcshooter.model.Model;

/**
 * @author Samuel Butta
 */
public interface GameCommand {

    public void execute(Model model);

}
