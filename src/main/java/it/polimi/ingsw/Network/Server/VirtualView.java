package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.GameManager;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Network.Messages.*;
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

    @Override
    public void updateFourLeaderCardsResponse(FourLeaderCardResponse fourLeaderCardResponse){
        System.out.println("E lo invia a: "+connection.getName());
        connection.send(fourLeaderCardResponse);
    }

    @Override
    public void updateLeaderCardsAfterFirstDiscard(TwoLeaderCardsResponse twoLeaderCardsResponse) {
        connection.send(twoLeaderCardsResponse);
    }

    @Override
    public void updateInitialResourcesSet(InitialResourcesSet initialResourcesSet){
        connection.send(initialResourcesSet);
    }
    public void updateMarketTrayActionResponse(MarketTrayActionResponse marketTrayActionResponse){
        connection.send(marketTrayActionResponse);
    }
    public void updateDealWithResourceFromMarketTrayresponse(DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse){
        connection.send(dealWithResourcesFromMarketTrayResponse);
    }
    public void updateWantToBuyCardResponse(WantToBuyCardResponse wantToBuyCardResponse){
        connection.send(wantToBuyCardResponse);
    }
    public void updateMoveResourcesResponse(MoveResourcesResponse moveResourcesResponse){
        connection.send(moveResourcesResponse);
    }
    public void updateWantActivateProductionResponse(WantActivateProductionResponse wantActivateProductionResponse){
        connection.send(wantActivateProductionResponse);
    }
    public void updateEndTurnResponse(EndTurnResponse endTurnResponse){
        connection.send(endTurnResponse);
    }
    public void updateActivateLeaderCardActionResponse(ActivateLeaderCardActionResponse activateLeaderCardActionResponse){
        connection.send(activateLeaderCardActionResponse);
    }
    public void updateDiscardLeaderCardActionResponse(DiscardLeaderCardActionResponse discardLeaderCardActionResponse){
        connection.send(discardLeaderCardActionResponse);
    }
    public void updateProductionResponse(ProductionResponse productionResponse){
        connection.send(productionResponse);
    }
    public void updateCardBuyedResponse(CardBuyedResponse cardBuyedResponse){
        connection.send(cardBuyedResponse);
    }
    public void updateFinishMultiplayerGame(FinishMultiplayerGame finishMultiplayerGame){
        connection.send(finishMultiplayerGame);
    }
    public void updateFinishSingleplayerGame(FinishSinglePlayerGame finishSinglePlayerGame) {
     connection.send(finishSinglePlayerGame);
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
