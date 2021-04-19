package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Player;

import javax.smartcardio.Card;

public class LeaderCard4 extends LeaderCard{ //converte in punto fede e materia a caso -> produzione extra
    private DevelopmentCard.colorCard CostCardLevelTwo;
    private ColoredMarble.ColorMarble ProductionCostResource;

    public LeaderCard4(int id, int victoryPoints, DevelopmentCard.colorCard CostCardLevelTwo, ColoredMarble.ColorMarble ProductionCostResource) {
        super(id, victoryPoints);
        this.CostCardLevelTwo = CostCardLevelTwo;
        this.ProductionCostResource = ProductionCostResource;
    }

    public boolean canBeActivated(Player player) {
        if(player.getSlots().filterCount(CostCardLevelTwo,2) >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    public DevelopmentCard.colorCard getCostCardLevelTwo() {
        return CostCardLevelTwo;
    }

    public ColoredMarble.ColorMarble getProductionCostResource() {
        return ProductionCostResource;
    }
}
//