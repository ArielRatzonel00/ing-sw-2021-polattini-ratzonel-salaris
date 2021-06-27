package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.MarkerStack;
import it.polimi.ingsw.Model.Model;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerGame;

public class PlusTwoBlackMarker extends Marker {
    @Override
    public int MarkerEffect(Model game) {
        return 2;
    } // Method that moves forward Lorenzo of two positions and shuffles the MarkerStack

    @Override
    public String getType() {
        return "+2 black positions";
    }
}
