package it.polimi.ingsw.Model;

public class RedMarble extends MarketMarble{
    @Override
    public void EffectOfMarble(Player player) {
        player.getFaithTrack().setRedPosition(1);
    }
}
