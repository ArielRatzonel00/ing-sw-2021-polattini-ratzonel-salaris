package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.FourLeaderCardResponse;
import it.polimi.ingsw.Network.Messages.TwoLeaderCardsResponse;

public interface VirtualViewObserver {
    void updateFourLeaderCardsResponse(FourLeaderCardResponse fourLeaderCardResponse);
    void updateLeaderCardsAfterFirstDiscard(TwoLeaderCardsResponse twoLeaderCardsResponse);
}
