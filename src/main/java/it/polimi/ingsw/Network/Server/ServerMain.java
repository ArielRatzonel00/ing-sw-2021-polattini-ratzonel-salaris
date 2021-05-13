package it.polimi.ingsw.Network.Server;

import java.io.IOException;

public class ServerMain {
    public static void main( String[] args )
    {
        Server server;
        try {
            server = new Server(1336);
            server.run();
        } catch (IOException e) {
            System.err.println("Impossible to initialize the server: " + e.getMessage() + "!");
        }
    }
}
