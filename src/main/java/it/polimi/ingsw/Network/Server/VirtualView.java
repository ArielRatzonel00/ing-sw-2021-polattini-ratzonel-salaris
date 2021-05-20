package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Observer.Observer;

public class VirtualView implements Observer<Model> {

    private SocketClientConnection connection;
    private GameManager multiplayerGameManager;

    public void setMultiplayerGameManager(GameManager multiplayerGameManager) {
        this.multiplayerGameManager = multiplayerGameManager;
    }

    public VirtualView(SocketClientConnection connection) {
        this.connection = connection;
    }

    @Override
    public void update(Model message, int code) {

    }
}
