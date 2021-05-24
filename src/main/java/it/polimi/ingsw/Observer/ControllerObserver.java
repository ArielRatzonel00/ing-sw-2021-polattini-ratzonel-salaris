package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.*;

public interface ControllerObserver<T>{
    void updateAssignFourLeaderCards(FourLeaderCardsMessage fourLeaderCardsMessage);
    void updateInitialResource(InitialResourcesMessage message);
    void updateDiscardLeaderCards(DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage);

    void updateWantActivateProduction(WantActivateProductionMessage wantActivateProductionMessage);

    void updateWantToBuyCard(WantToBuyCardMessage wantToBuyCardMessage);

    void updateMarketTrayAction(MarketTrayActionMessage marketTrayActionMessage);

    void updateDealWithAResourceFromMarketTray(DealWithAResourceFromMarketTrayMessage dealWithAResourceFromMarketTrayMessage);

    void updateMoveResources(MoveResourcesMessage moveResourcesMessage);

    void updateDiscardLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage);

    void updateActivateLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage);
    void updateBuyCard(BuyCardMessage buyCardMessage);
    void updateProduce(ProduceMessage produceMessage);
    void updateEndOfTurn(EndOfTurnMessage endOfTurnMessage);

}