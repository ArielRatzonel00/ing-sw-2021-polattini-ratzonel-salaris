package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Player;

public class LeaderCard1 extends LeaderCard { //metodo per leader cards che trasformano pallina bianca in altri colori


    private DevelopmentCard.colorCard colorCostOne;
    private DevelopmentCard.colorCard colorCostTwo;
    private ColoredMarble.ColorMarble NewColorMarble;
    public LeaderCard1(int id, int victoryPoints, DevelopmentCard.colorCard colorCostOne, DevelopmentCard.colorCard colorCostTwo, ColoredMarble.ColorMarble NewColorMarble) {
        super(id,victoryPoints);
        this.colorCostOne = colorCostOne;
        this.colorCostTwo = colorCostTwo;
        this.NewColorMarble = NewColorMarble;
    }

    @Override
    public boolean canBeActivated(Player player) {
        if((player.getSlotsBoard().filterCount(colorCostOne) >= 1) && (player.getSlotsBoard().filterCount(colorCostTwo)>= 2)){
            return true;
        }
        else {
            return false;
        }
    }
}
