package it.polimi.ingsw.Model;

public class PlusOneShuffleMarker extends Marker{
    @Override
    public void MarkerEffect(Player player) {
        player.getFaithTrack().setBlackPosition(1);
    }
}
