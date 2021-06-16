package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Markers.Marker;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Network.Server.VirtualView;


import java.util.ArrayList;
import java.util.List;

public class ModelObservable extends Observable<VirtualView> {
    private final List<VirtualView> observers = new ArrayList<>();
    public void addObserver(VirtualView observer){
        synchronized (observers) {
            observers.add(observer);
        }
    }
    public void notifyDisconnection(){
        for (VirtualView obs:observers
        )
                obs.handleDisconnection(new DisconnectionMessage());
    }
    public void notifyFourLeaderCards(int PlayerIndex, ArrayList<LeaderCard> leaderCards, ArrayList<DevelopmentCard> developmentGrid, MarketTray marketTray, String nickname, boolean isSinglePlayerGame, MarkerStack markers){

        FourLeaderCardResponse fourLeaderCardResponse = new FourLeaderCardResponse(leaderCards);
        fourLeaderCardResponse.setNickname(nickname);
        fourLeaderCardResponse.setTopCards(developmentGrid);
        fourLeaderCardResponse.setMarketTray(marketTray);
        fourLeaderCardResponse.setPlayerIndex(PlayerIndex);
        fourLeaderCardResponse.setSinglePlayer(isSinglePlayerGame);
        fourLeaderCardResponse.setMarkers(markers.getMarkers());
        System.out.println("le crea e le invia all'indice: "+fourLeaderCardResponse.getPlayerIndex());

        //fourLeaderCardResponse.setLeaderCards(leaderCards);
        for (VirtualView obs:observers
             ) {
            obs.updateFourLeaderCardsResponse(fourLeaderCardResponse);
        }
    }


    public void notifyLeaderCardsAfterFirstDiscard(int PlayerIndex, ArrayList<LeaderCard> leaderCards, ArrayList<Production> productions){
        TwoLeaderCardsResponse twoLeaderCardsResponse = new TwoLeaderCardsResponse();
        twoLeaderCardsResponse.setPlayerIndex(PlayerIndex);
        twoLeaderCardsResponse.setLeaderCards(leaderCards);
        twoLeaderCardsResponse.setProductions(productions);
        for (VirtualView obs:observers
        ) {
            obs.updateLeaderCardsAfterFirstDiscard(twoLeaderCardsResponse);
        }    }

    public void notifyInitialResourcesSet(int playerIndex, boolean start, Warehouse warehouse, int faithTrackPosition){
        InitialResourcesSet initialResourcesSet=new InitialResourcesSet();
        initialResourcesSet.setPosition(faithTrackPosition);
        initialResourcesSet.setStart(start);
        initialResourcesSet.setWarehouse(warehouse);
        initialResourcesSet.setPlayerIndex(playerIndex);
        for (VirtualView obs:observers
        ) {
            obs.updateInitialResourcesSet(initialResourcesSet);
        }
    }
    public void notifyDealWithResourceFromMarketTrayresponse(int playerIndex,Warehouse warehouse, int CurrPlayerAdvances, int OtherPlayerAdvances, boolean PopeFavorStateChanged,ArrayList<PopeFavorState> popeFavorStates){
        DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse = new DealWithResourcesFromMarketTrayResponse();
        System.out.println(playerIndex);
        dealWithResourcesFromMarketTrayResponse.setPlayerIndex(playerIndex);
        dealWithResourcesFromMarketTrayResponse.setWarehouse(warehouse);
        dealWithResourcesFromMarketTrayResponse.setCurrPlayersAdvances(CurrPlayerAdvances);
        dealWithResourcesFromMarketTrayResponse.setOtherPlayersAdvances(OtherPlayerAdvances);
        dealWithResourcesFromMarketTrayResponse.setPopeFavoreEvent(PopeFavorStateChanged);
        dealWithResourcesFromMarketTrayResponse.setPopeFavorStates(popeFavorStates);
        for (VirtualView obs:observers
        ) {
            obs.updateDealWithResourceFromMarketTrayresponse(dealWithResourcesFromMarketTrayResponse);
            System.out.println("Arriva in obs.update");
        }
    }


    public void notifyMarketTrayActionResponse(int PlayerIndex,MarketMarble[][] marketTray, MarketMarble outsideMarble, ArrayList<MarketMarble> returnedmarbles, MarketMarble.ColorMarble ChangeWhite1, MarketMarble.ColorMarble ChangeWhite2  ){
        MarketTrayActionResponse marketTrayActionResponse = new MarketTrayActionResponse();
        marketTrayActionResponse.setPlayerIndex(PlayerIndex);
        marketTrayActionResponse.setMarketTray(marketTray);
        marketTrayActionResponse.setOutsideMarble(outsideMarble);
        marketTrayActionResponse.setReturnedmarbles(returnedmarbles);
        marketTrayActionResponse.setChangeWhite1(ChangeWhite1);
        marketTrayActionResponse.setChangeWhite1(ChangeWhite2);
        for (VirtualView obs:observers
        ) {
            obs.updateMarketTrayActionResponse(marketTrayActionResponse);
        }
    }
    public void notifyWantToBuyCardResponse(int PlayerIndex, String phraseToShow,int row,int col, int slot, ArrayList<CostOfCard> cost){
        WantToBuyCardResponse wantToBuyCardResponse = new WantToBuyCardResponse();
        wantToBuyCardResponse.setPhrasetoShow(phraseToShow);
        wantToBuyCardResponse.setPlayerIndex(PlayerIndex);
        wantToBuyCardResponse.setCost(cost);
        wantToBuyCardResponse.setSlot(slot);
        wantToBuyCardResponse.setCellRow(row);
        wantToBuyCardResponse.setCellCol(col);
        for (VirtualView obs:observers
        ) {
            obs.updateWantToBuyCardResponse(wantToBuyCardResponse);
        }
    }

    public void notifyMoveResourcesResponse(int PlayerIndex, boolean ok, Warehouse newwarehouse){
        MoveResourcesResponse moveResourcesResponse = new MoveResourcesResponse();
        moveResourcesResponse.setPlayerIndex(PlayerIndex);
        moveResourcesResponse.setOk(ok);
        moveResourcesResponse.setNewwarehouse(newwarehouse.getRows());
        for (VirtualView obs:observers
        ) {
            obs.updateMoveResourcesResponse(moveResourcesResponse);
        }
    }

    public void notifyCardBuyedResponse(int PlayerIndex, ArrayList<DevelopmentCard> topcards, Warehouse newwarehouse, Strongbox newstrongbox, DevelopmentCard card, ArrayList<Production> newproductionavailables, int slot){
        CardBuyedResponse cardBuyedResponse = new CardBuyedResponse();
        cardBuyedResponse.setPlayerIndex(PlayerIndex);
        cardBuyedResponse.setNewwarehouse(newwarehouse.getRows());
        cardBuyedResponse.setNewstrongbox(newstrongbox.allResources());
        cardBuyedResponse.setCard(card);
        cardBuyedResponse.setSlot(slot);
        cardBuyedResponse.setNewproductionAvailables(newproductionavailables);
        cardBuyedResponse.setNewDevGrid(topcards);
        for (VirtualView obs:observers
        ) {
            obs.updateCardBuyedResponse(cardBuyedResponse);
        }
    }
    public void notifyWantActivateProductionResponse(int PlayerIndex, ArrayList<CostOfCard> productionBasicCost, ArrayList<Integer> productions, boolean ok){
        WantActivateProductionResponse wantActivateProductionResponse = new WantActivateProductionResponse();
        wantActivateProductionResponse.setPlayerIndex(PlayerIndex);
        wantActivateProductionResponse.setBasicProductionCost(productionBasicCost);
        wantActivateProductionResponse.setProductions(productions);
        wantActivateProductionResponse.setOk(ok);
        for (VirtualView obs:observers
        ) {
            obs.updateWantActivateProductionResponse(wantActivateProductionResponse);
        }
    }
    public void notifyProductionResponse(int PlayerIndex, ArrayList<WarehouseRow> newwarehouse, ArrayList<Integer> newstrongbox, int faithTrackPositions, boolean popeFavor, ArrayList<PopeFavorState> popeFavorStates){
        ProductionResponse productionResponse = new ProductionResponse();
        productionResponse.setPlayerIndex(PlayerIndex);
        productionResponse.setNewwarehouse(newwarehouse);
        productionResponse.setNewstrongbox(newstrongbox);
        productionResponse.setFaithTrackpositions(faithTrackPositions);
        productionResponse.setPopeFavoreStateEvent(popeFavor);
        productionResponse.setPopeFavorStates(popeFavorStates);
        for (VirtualView obs:observers
        ) {
            obs.updateProductionResponse(productionResponse);
        }

    }
    public void notifyNewTurn(int NewTurnPlayerIndex, int blackPosition, boolean popeFavorStateChanged, ArrayList<PopeFavorState> popeFavorStates, Marker topMarker, ArrayList<DevelopmentCard> newDevGrid){
        EndTurnResponse endTurnResponse = new EndTurnResponse();
        endTurnResponse.setBlackPosition(blackPosition);
        endTurnResponse.setPopeFavorChanged(popeFavorStateChanged);
        endTurnResponse.setTopMarker(topMarker);
        endTurnResponse.setNewDevGrid(newDevGrid);
        endTurnResponse.setPopeFavorStates(popeFavorStates);
        endTurnResponse.setIndexNewTurn(NewTurnPlayerIndex);
        for (VirtualView obs:observers
        ) {
            obs.updateEndTurnResponse(endTurnResponse);
        }
    }
    public void notifyActivateLeaderCardActionResponse(int playerIndex, int cardIndex, boolean ok){
        ActivateLeaderCardActionResponse activateLeaderCardActionResponse = new ActivateLeaderCardActionResponse();
        activateLeaderCardActionResponse.setOk(ok);
        activateLeaderCardActionResponse.setPlayerIndex(playerIndex);
        for (VirtualView obs:observers
        ) {
            obs.updateActivateLeaderCardActionResponse(activateLeaderCardActionResponse);
        }
    }
    public void notifyDiscardLeaderCardActionResponse(int playerIndex, int cardIndex, boolean PopeFavorStateChanged, boolean ok, ArrayList<PopeFavorState> popeFavorStates){
        DiscardLeaderCardActionResponse discardLeaderCardActionResponse = new DiscardLeaderCardActionResponse();
        discardLeaderCardActionResponse.setPlayerIndex(playerIndex);
        discardLeaderCardActionResponse.setOk(ok);
        discardLeaderCardActionResponse.setPopeFavorStateEvent(PopeFavorStateChanged);
        discardLeaderCardActionResponse.setPopeFavorStates(popeFavorStates);
        discardLeaderCardActionResponse.setCardIndex(cardIndex);
        for (VirtualView obs:observers
        ) {
            obs.updateDiscardLeaderCardActionResponse(discardLeaderCardActionResponse);
        }
    }
    public void notifyFinishMultiplayerGame(String winnerplayer){
        FinishMultiplayerGame finishMultiplayerGame = new FinishMultiplayerGame();
        finishMultiplayerGame.setWinnerPlayer(winnerplayer);
        for (VirtualView obs:observers
        ) {
            obs.updateFinishMultiplayerGame(finishMultiplayerGame);
        }
    }
    public void notifyFinishSingleplayerGame(boolean RedWon, int points){
        FinishSinglePlayerGame finishSinglePlayerGame = new FinishSinglePlayerGame();
        finishSinglePlayerGame.setRedWon(RedWon);
        finishSinglePlayerGame.setTotPoints(points);
        for (VirtualView obs:observers
        ) {
            obs.updateFinishSingleplayerGame(finishSinglePlayerGame);
        }
    }
    /*protected void notify(T message, int code){
        synchronized (observers) {
            for(Observer<T> observer : observers){
                observer.update(message,code);
            }
        }
    }*/

}
