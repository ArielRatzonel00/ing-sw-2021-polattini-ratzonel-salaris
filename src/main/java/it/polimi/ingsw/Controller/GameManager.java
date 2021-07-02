package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Network.Server.VirtualView;
import it.polimi.ingsw.Observer.ControllerObserver;
import it.polimi.ingsw.Observer.Observable;

import java.util.*;


public class GameManager extends Observable<Model> implements ControllerObserver<VirtualView> {
    private Model game;
    private Player CurrentPlayer;
    private ArrayList<Player> OtherPlayers;
    private boolean IsSinglePlayer = false;
    private boolean FinishGame = false;
    private int a;

    public GameManager(Model game) {
        this.game = game;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        IsSinglePlayer = singlePlayer;
    }

    @Override
    public synchronized void  updateAssignFourLeaderCards(FourLeaderCardsMessage fourLeaderCardsMessage) {
        game.AssignFourLeaderCards(fourLeaderCardsMessage.getPlayerIndex());
    }


    public synchronized void updateDiscardLeaderCards(DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage) {
        game.DiscardInitialLeaderCards(discardInitialLeaderCardsMessage.getPlayerIndex(), discardInitialLeaderCardsMessage.getIndexLeaderCard1(), discardInitialLeaderCardsMessage.getIndexLeaderCard2() - 1);
    }

    public synchronized void updateInitialResource(InitialResourcesMessage initialResourcesMessage) {
        if (initialResourcesMessage.getPlayerIndex() == 1) {
            game.SetInitialResourcesForSecondPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1());
        } else if (initialResourcesMessage.getPlayerIndex() == 2) {
            game.SetInitialResourcesForThirdPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1());
        } else if (initialResourcesMessage.getPlayerIndex() == 3) {
            game.SetInitialResourcesForForthPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1(), initialResourcesMessage.getColorMarble2(), initialResourcesMessage.getRow2());
        }
        else if(initialResourcesMessage.getPlayerIndex()==0)
            game.SetInitialResourcesForFirstPlayer();
    }

    public synchronized  void updateWantToBuyCard(WantToBuyCardMessage wantToBuyCardMessage) {
        game.WantToBuyCard(wantToBuyCardMessage.getPlayerIndex(), wantToBuyCardMessage.getRow(), wantToBuyCardMessage.getCol(), wantToBuyCardMessage.getSlot());
    }

    public synchronized  void updateBuyCard(BuyCardMessage buyCardMessage) {
        game.BuyCard(buyCardMessage.getPlayerIndex(), buyCardMessage.getResourcesFromStrongbox(), buyCardMessage.getResourcesFromWarehouse(), buyCardMessage.getRows(), buyCardMessage.getCellrow(), buyCardMessage.getCellcol(), buyCardMessage.getSlot());
    }

    public synchronized void updateMarketTrayAction(MarketTrayActionMessage marketTrayActionMessage) {
        game.MarketTrayAction(marketTrayActionMessage.getPlayerIndex(), marketTrayActionMessage.isRow(), marketTrayActionMessage.getIndex());
    }

    public synchronized  void updateDealWithAResourceFromMarketTray(DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage) {
        game.DealWithResources(dealWithResourcesFromMarketTrayMessage.getPlayerIndex(), dealWithResourcesFromMarketTrayMessage.getKeeps(), dealWithResourcesFromMarketTrayMessage.getMarbles(), dealWithResourcesFromMarketTrayMessage.getRows());
    }

    public synchronized void updateMoveResources(MoveResourcesMessage moveResourcesMessage) {
        game.MoveResources(moveResourcesMessage.getPlayerIndex(), moveResourcesMessage.getRow1(), moveResourcesMessage.getRow2());
    }

    public synchronized void updateWantActivateProduction(WantActivateProductionMessage wantActivateProductionMessage) {
        game.CanProduce(wantActivateProductionMessage.getPlayerIndex(), wantActivateProductionMessage.getProductions(), wantActivateProductionMessage.getProductionBasicCost());
    }

    public synchronized  void updateProduce(ProduceMessage produceMessage) {

        game.Produce(produceMessage.getPlayerIndex(),produceMessage.getProductions(),produceMessage.getResourcesFromStrongbox(),produceMessage.getResourcesFromWarehouse(),produceMessage.getRows(),produceMessage.getProductionProfit());
        }

    public synchronized void updateDiscardLeaderCardAction(DiscardLeaderCardActionMessage discardLeaderCardActionMessage) {
        game.DiscardLeaderCardAction(discardLeaderCardActionMessage.getPlayerIndex(), discardLeaderCardActionMessage.getLeaderCardIndex());
    }

    public synchronized void updateActivateLeaderCardAction(ActivateLeaderCardActionMessage activateLeaderCardActionMessage) {
        game.ActivateLeaderCardAction(activateLeaderCardActionMessage.getPlayerIndex(), activateLeaderCardActionMessage.getLeaderCardIndex());
    }

    public synchronized void updateEndOfTurn(EndOfTurnMessage endOfTurnMessage) {
        game.EndTurn(endOfTurnMessage.getPlayerIndex());
    }

    public synchronized void updateDisconnection(){
        game.setDisconnection(true);
    }
}

