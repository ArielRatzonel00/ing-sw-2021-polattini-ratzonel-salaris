package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Model.MultiplayerGame;
import it.polimi.ingsw.Observer.Observer;

public class VirtualView implements Observer<MultiplayerGame> {

    private SocketClientConnection connection;

    public VirtualView(SocketClientConnection connection) {
        this.connection = connection;
    }

    @Override
    public void update(MultiplayerGame message, int code) {

    }
}
