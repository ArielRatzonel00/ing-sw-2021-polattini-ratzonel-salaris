package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.Model;

public class PlusOneShuffleMarker extends Marker {
    @Override
    public int MarkerEffect(Model game) {
        game.getMarkers().Shuffle();
        return 1;
    } // Method that moves forward Lorenzo of one position and shuffles the MarkerStack

    @Override
    public String getType() {
        return "+1 black position and shuffle markers";
    }
}
