package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.*;

public interface ControllerObserver<T>{
    void updateInitialResource(InitialResourcesMessage message);

    void updateDiscardLeaderCards(DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage);

    void updateActivateProduction(ActivateProductionMessage activateProductionMessage);

    void updateWantToBuyCard(WantToBuyCardMessage wantToBuyCardMessage);

    void updateMarketTrayAction(MarketTrayActionMessage marketTrayActionMessage);

    void updateDealWithAResourceFromMarketTray(DealWithAResourceFromMarketTrayMessage dealWithAResourceFromMarketTrayMessage);

    void updateMoveResources(MoveResourcesMessage moveResourcesMessage);

    void updateDiscardLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage);

    void updateActivateLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage);
}