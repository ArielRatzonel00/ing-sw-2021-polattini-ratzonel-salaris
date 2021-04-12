package it.polimi.ingsw.Model;

public class PlusTwoBlackMarker extends Marker {
    @Override
    public void MarkerEffect(Player player) {
        player.getFaithTrack().setBlackPosition(2);
    }
}
