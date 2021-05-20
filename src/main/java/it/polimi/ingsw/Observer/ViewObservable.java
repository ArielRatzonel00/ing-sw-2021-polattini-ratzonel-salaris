package it.polimi.ingsw.Observer;

import java.util.ArrayList;

public abstract class ViewObservable extends Observable<ViewObservable> {
    protected final ArrayList<ViewObserver> observers = new ArrayList<>();
    public void addObserver(ViewObserver viewObserver){
        observers.add(viewObserver);
    }
    public synchronized void notifyNickname(){
    }

}
