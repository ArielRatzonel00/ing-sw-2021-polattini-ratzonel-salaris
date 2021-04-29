package it.polimi.ingsw.Network.Server;
import java.io.IOException;

public class ServerMain
{
    public static void main( String[] args )
    {
        Server server = new Server(1336);
        try {
            server.startServer();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
