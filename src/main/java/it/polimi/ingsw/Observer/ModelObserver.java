package it.polimi.ingsw.Observer;

public interface ModelObserver<T>{
    void update(T message, int code);

}
