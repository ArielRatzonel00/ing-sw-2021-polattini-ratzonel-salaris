package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerGame;

public class RemoveCardsMarker extends Marker {
    @Override
    public void MarkerEffect(Player player, SinglePlayerGame singlePlayerGame) {
        singlePlayerGame.getDevelopmentGrid()
        //Gli passo Livello livello della carta da scartare e mi calcolo le coordinate in base a quello
    }
}
