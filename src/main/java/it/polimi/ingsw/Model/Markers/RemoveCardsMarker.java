package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Model;

public class RemoveCardsMarker extends Marker {

    private DevelopmentCard.colorCard colorCard;

    public RemoveCardsMarker(DevelopmentCard.colorCard colorCard) {
        this.colorCard = colorCard;
    }

    @Override
    public int MarkerEffect(Model game) {
        game.getDevelopmentGrid().RemoveCardByColor(colorCard);
        game.getDevelopmentGrid().RemoveCardByColor(colorCard);
        return 0;
    } // Method that removes the tow bottom card of the lowest level that are still in the DevelopmentGrid

    @Override
    public String getType() {
        return "-2 " + colorCard;
    }
}
