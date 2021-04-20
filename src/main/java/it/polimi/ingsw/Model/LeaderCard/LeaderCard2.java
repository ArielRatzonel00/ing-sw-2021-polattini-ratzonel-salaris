package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Player;

public class LeaderCard2 extends LeaderCard { //metodo per leader cards che diminuisce costo
    private DevelopmentCard.colorCard FirstcolorCost;
    private DevelopmentCard.colorCard SecondcolorCost;
    private ColoredMarble.ColorMarble Discount;

    public LeaderCard2(int id, int victoryPoints, DevelopmentCard.colorCard FirstcolorCost, DevelopmentCard.colorCard SecondcolorCost, ColoredMarble.ColorMarble Discount) {
        super(id, victoryPoints);
        this.FirstcolorCost = FirstcolorCost;
        this.SecondcolorCost = SecondcolorCost;
        this.Discount = Discount;
    }

    @Override
    public boolean canBeActivated(Player player) {
        if ((player.getSlotsBoard().filterCount(FirstcolorCost) >= 1) && (player.getSlotsBoard().filterCount(SecondcolorCost) >= 1)) {
            return true;
        } else {
            return false;
        }
    }

    public DevelopmentCard.colorCard getFirstcolorCost() {
        return FirstcolorCost;
    }

    public DevelopmentCard.colorCard getSecondcolorCost() {
        return SecondcolorCost;
    }

    public ColoredMarble.ColorMarble getDiscount() {
        return Discount;
    }
}
