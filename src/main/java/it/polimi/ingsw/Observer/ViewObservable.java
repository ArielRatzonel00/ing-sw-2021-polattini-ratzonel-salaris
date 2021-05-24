package it.polimi.ingsw.Observer;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class ViewObservable extends Observable<ViewObservable> {
    protected final ArrayList<ViewObserver> observers = new ArrayList<>();
    public void addObserver(ViewObserver viewObserver){
        observers.add(viewObserver);
    }

    protected synchronized void notifyObserver(Consumer<ViewObserver> lambda){
        for (ViewObserver observer : observers) {
            lambda.accept(observer);
        }
    }

}
