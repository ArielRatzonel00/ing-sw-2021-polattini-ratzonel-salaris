package it.polimi.ingsw.Model;

public class PlusOneShuffleMarker extends Marker{
    @Override
    public void MarkerEffect(Player player, SinglePlayerGame singlePlayerGame) {
        player.getFaithTrack().setBlackPosition(1);
        singlePlayerGame.getMarkers().Shuffle();
    }
}
