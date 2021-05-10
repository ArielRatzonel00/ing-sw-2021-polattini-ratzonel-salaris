package it.polimi.ingsw.Network.Server;

import java.util.Observer;

public interface ClientConnection {
    void closeConnection();
    void addObserver(Observer<String> observer);
    void asyncSend(Object message);



}
