package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.SocketMessage;
import it.polimi.ingsw.Observer.ModelObserver;
import it.polimi.ingsw.Observer.Observable;
import it.polimi.ingsw.Observer.Observer;

import java.io.IOException;

public class VirtualView extends Observable implements ModelObserver<Model> {

    private SocketClientConnection connection;
    private GameManager GameManager;

    public void setGameManager(GameManager GameManager) {
        this.GameManager = GameManager;
    }

    public VirtualView(SocketClientConnection connection) {
        this.connection = connection;
    }

    @Override
    public void update(Model message, int code) {
        System.out.println("A updated");
        System.out.println("A vale"+message.GetA());
        connection.send(message.GetA());
    }

   /* @Override
    public void updateTest(SocketMessage message) throws IOException {
        connection.sendMessage(connection.getOut(), message);
    }*/

    public GameManager getGameManager() {
        return GameManager;
    }
}
