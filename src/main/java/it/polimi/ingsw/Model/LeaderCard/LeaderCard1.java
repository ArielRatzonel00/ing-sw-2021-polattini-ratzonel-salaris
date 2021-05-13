package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;

public class LeaderCard1 extends LeaderCard { //metodo per leader cards che trasformano pallina bianca in altri colori


    private DevelopmentCard.colorCard colorCostOne;
    private DevelopmentCard.colorCard colorCostTwo;
    private MarketMarble.ColorMarble NewColorMarble;
    public LeaderCard1(int id, int victoryPoints, DevelopmentCard.colorCard colorCostOne, DevelopmentCard.colorCard colorCostTwo, MarketMarble.ColorMarble NewColorMarble) {
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
    @Override
    public String StampaCarta(){
        return  "POTERE: Trasforma palline bianche in palline : " + getNewColorMarble() + "\n" +
                "NECESSITA: 1 devCard colore " + getColorCostOne() + ", 2 devCard colore " + getColorCostTwo() + "\n" +
                "VICTORY POINTS: " + getVictoryPoints();
    }

    public DevelopmentCard.colorCard getColorCostOne() {
        return colorCostOne;
    }

    public DevelopmentCard.colorCard getColorCostTwo() {
        return colorCostTwo;
    }

    public MarketMarble.ColorMarble getNewColorMarble() {
        return NewColorMarble;
    }
}
