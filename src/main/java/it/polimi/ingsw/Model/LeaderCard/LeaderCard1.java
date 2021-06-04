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
        return  "Power: white marble →: " + getNewColorMarble() + "\n" +
                "Requirements: 1 devCard " + getColorCostOne() + ", 2 devCard " + getColorCostTwo() + "\n" +
                "VP: " + getVictoryPoints();
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
    @Override
    public String toString() {
        return "LeaderCard1{" +
                "victoryPoints=" + getVictoryPoints() +
                ", colorCostOne="+getColorCostOne() +
                ",colorCostTwo="+getColorCostTwo()+
                ",colorMarble"+getNewColorMarble()+
                '}';
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public void effect(Player player) {
        if (player.getChangeWhite1()!= MarketMarble.ColorMarble.WHITE){
            player.setChangeWhite2(getNewColorMarble());
        }
        else {
            player.setChangeWhite1(getNewColorMarble());
        }
    }
}
