package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.*;

import java.io.IOException;

public interface Observer<T> {

    void update(T message, int code);

    //void updateTest(SocketMessage message) throws IOException;

}