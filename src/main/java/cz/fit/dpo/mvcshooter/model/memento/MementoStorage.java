package cz.fit.dpo.mvcshooter.model.memento;

import java.util.Stack;

/**
 * @author Samuel Butta
 */
public class MementoStorage {

    Stack<Memento> mementos = new Stack<>();

    public void saveMemento(Memento memento) {
        mementos.push(memento);
    }

    public Memento lastMemento() {
        return mementos.pop();
    }

}
