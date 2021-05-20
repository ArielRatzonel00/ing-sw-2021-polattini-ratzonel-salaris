package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to keep memory of all specific observers and notify them.
 *
 * @param <T> is a generic object that observers observe.
 */
public class Observable<T> {

    private final List<Observer<T>> observers = new ArrayList<>();

    /**
     * This method is used to add a new observer.
     *
     * @param observer is the entity of the new observer.
     */
    public void addObserver(Observer<T> observer){
        synchronized (observers) {
            observers.add(observer);
        }
    }

    /**
     * This method notifies all observer in the list.
     *
     * @param message is the generic observed object.
     */
    protected void notify(T message, int code){
        synchronized (observers) {
            for(Observer<T> observer : observers){
                observer.update(message,code);
            }
        }
    }

    /*protected void notifyTest(Message message) throws IOException {
        synchronized (observers) {
            for(Observer<T> observer : observers){
                observer.updateTest(message);
            }
        }
    }*/

}