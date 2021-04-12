package it.polimi.ingsw.Model;

public class PlusTwoBlackMarker extends Marker {
    @Override
    public void MarkerEffect(Player player, SinglePlayerGame singlePlayerGame) {
        player.getFaithTrack().setBlackPosition(2);
    }
}
