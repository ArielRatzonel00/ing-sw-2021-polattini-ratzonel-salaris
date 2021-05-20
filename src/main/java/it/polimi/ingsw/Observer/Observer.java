package it.polimi.ingsw.Observer;

import it.polimi.ingsw.message.*;

public interface Observer<T> {

    void update(T message, int code);
    void updateInitialResource(InitialResourcesMessage message);
    void updateDiscardLeaderCards(DiscardLeaderCardMessage discardLeaderCardMessage);
    void updateActivateProduction(ActivateProductionMessage activateProductionMessage);
    void updateWantToBuyCard(WantToBuyCardMessage wantToBuyCardMessage);
    void updateMarketTrayAction(MarketTrayActionMessage marketTrayActionMessage);

}
