package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.Lobby;

import java.io.IOException;

public class ServerSocketManager
{

    int[] ports={1337,1338,1339,1340,1341};
    int i=0;

    public void start(){
        Lobby GameLobby = Lobby.getInstance();
        if(Lobby.getInstance().isFull()){
            Server server=new Server(i);
            try {
                server.startServer();
                i++;
                GameLobby.setFull(false);

            } catch(IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}


