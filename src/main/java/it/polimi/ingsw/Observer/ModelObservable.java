package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Model.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelObservable{
    private final List<ModelObserver<Model>> observers = new ArrayList<>();
    public void addObserver(ModelObserver<Model> observer){
        synchronized (observers) {
            observers.add(observer);
        }
    }

    /*protected void notify(T message, int code){
        synchronized (observers) {
            for(Observer<T> observer : observers){
                observer.update(message,code);
            }
        }
    }*/

}
