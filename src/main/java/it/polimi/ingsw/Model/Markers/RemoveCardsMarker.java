package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerGame;

public class RemoveCardsMarker extends Marker {

    private DevelopmentCard.colorCard colorCard;

    public RemoveCardsMarker(DevelopmentCard.colorCard colorCard) {
        this.colorCard = colorCard;
    }

    @Override
    public void MarkerEffect(Player player, SinglePlayerGame singlePlayerGame) {
        singlePlayerGame.getDevelopmentGrid().RemoveCardByColor(colorCard);
        singlePlayerGame.getDevelopmentGrid().RemoveCardByColor(colorCard);

        //Gli passo Livello livello della carta da scartare e mi calcolo le coordinate in base a quello
    }
}
