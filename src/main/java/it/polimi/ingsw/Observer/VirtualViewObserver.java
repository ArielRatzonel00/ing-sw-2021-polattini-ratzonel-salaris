package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.*;

import java.util.ArrayList;

public interface VirtualViewObserver {
    void updateFourLeaderCardsResponse(FourLeaderCardResponse fourLeaderCardResponse);
    void updateLeaderCardsAfterFirstDiscard(TwoLeaderCardsResponse twoLeaderCardsResponse);
    void updateInitialResourcesSet(InitialResourcesSet initialResourcesSet);
    void updateDealWithResourceFromMarketTrayresponse(DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse);
    void updateMarketTrayActionResponse(MarketTrayActionResponse marketTrayActionResponse);
    void updateWantToBuyCardResponse(WantToBuyCardResponse wantToBuyCardResponse);
    void updateMoveResourcesResponse(MoveResourcesResponse moveResourcesResponse);
    void updateWantActivateProductionResponse(WantActivateProductionResponse wantActivateProductionResponse);
    void updateEndTurnResponse(EndTurnResponse endTurnResponse);
    void updateActivateLeaderCardActionResponse(ActivateLeaderCardActionResponse activateLeaderCardActionResponse);
    void updateDiscardLeaderCardActionResponse(DiscardLeaderCardActionResponse discardLeaderCardActionResponse);
    void updateProductionResponse(ProductionResponse productionResponse);
    void updateCardBuyedResponse(CardBuyedResponse cardBuyedResponse);

}
