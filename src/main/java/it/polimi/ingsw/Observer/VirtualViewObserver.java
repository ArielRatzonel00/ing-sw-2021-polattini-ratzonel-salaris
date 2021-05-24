package it.polimi.ingsw.Observer;

import it.polimi.ingsw.Network.Messages.FourLeaderCardResponse;

public interface VirtualViewObserver {
    void updateFourLeaderCardsResponse(FourLeaderCardResponse fourLeaderCardResponse);
}
