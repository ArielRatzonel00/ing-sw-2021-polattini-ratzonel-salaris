package it.polimi.ingsw.Network.Messages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract class  Messanger {

    public synchronized void sendMessage(ObjectOutputStream out, SocketMessage message) throws IOException {
        System.out.println("Stream creato");
        out.reset();
        out.writeObject(message);
        System.out.println("inviato");
        out.flush();
    }

    public abstract void receiveMessage(SocketMessage message) throws IOException;

}
