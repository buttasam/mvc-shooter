package cz.fit.dpo.mvcshooter.model.visitor;

/**
 * @author Samuel Butta
 */
public interface Visitable {

    public void accept(Visitor visitor);

}
