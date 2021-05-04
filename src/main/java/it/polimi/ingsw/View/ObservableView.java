package it.polimi.ingsw.View;

import java.util.Observable;
import java.util.Observer;

public class ObservableView extends Observable {

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }
}
