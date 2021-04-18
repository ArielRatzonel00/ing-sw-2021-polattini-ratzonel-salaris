package it.polimi.ingsw.Model.Marble;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;

public class RedMarble extends MarketMarble {
    @Override
    public void EffectOfMarble(Player player) {
        player.getFaithTrack().setRedPosition(1);
    }
}
