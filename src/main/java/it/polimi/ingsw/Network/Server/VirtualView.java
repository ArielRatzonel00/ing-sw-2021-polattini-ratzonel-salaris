package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Network.Messages.FourLeaderCardResponse;
import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.SocketMessage;
import it.polimi.ingsw.Network.Messages.TwoLeaderCardsResponse;
import it.polimi.ingsw.Observer.*;


import java.io.IOException;

public class VirtualView extends VirtualViewObservable implements VirtualViewObserver {

    private SocketClientConnection connection;
    //private GameManager GameManager;

    /*public void setGameManager(GameManager GameManager) {
        this.GameManager = GameManager;
    }

     */

    public VirtualView(SocketClientConnection connection) {
        this.connection = connection;
    }
    public void updateFourLeaderCardsResponse(FourLeaderCardResponse fourLeaderCardResponse){
        System.out.println("E lo invia a: "+connection.getName());
        connection.send(fourLeaderCardResponse);
    }

    @Override
    public void updateLeaderCardsAfterFirstDiscard(TwoLeaderCardsResponse twoLeaderCardsResponse) {

    }

   /* @Override
    public void updateTest(SocketMessage message) throws IOException {
        connection.sendMessage(connection.getOut(), message);
    }*/

    /*public GameManager getGameManager() {
        return GameManager;
    }

     */
}
