package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Production;



public class LeaderCard4 extends LeaderCard { //converte in punto fede e materia a caso -> produzione extra
    private int type;
    private DevelopmentCard.colorCard CostCardLevelTwo;
    private Production production;

    public LeaderCard4(int id, DevelopmentCard.colorCard CostCardLevelTwo, int victoryPoints, Production production) {
        super(id, victoryPoints);
        type=4;
        this.CostCardLevelTwo = CostCardLevelTwo;
        this.production = production;
    }

    public boolean canBeActivated(Player player) {
        return player.getSlotsBoard().filterCount(CostCardLevelTwo, 2) >= 1;
    }

    public DevelopmentCard.colorCard getCostCardLevelTwo() {
        return CostCardLevelTwo;
    }

    public Production getProduction() {
        return production;
    }

    public void effect(Player player) {
        player.newProductionFromLeaderCard(production);
    }

    @Override
    public String toString() {
        return "LeaderCard4{" +
                "victoryPoints=" + getVictoryPoints() +
                ", CostaCardLevelTwo="+getCostCardLevelTwo() +
                ",production="+getProduction()+
                '}';
    }
    @Override
    public String StampaCarta() {
        return "Power: Extra production pay: " + getProduction().getProductionCost().get(0).getCostNumber() + getProduction().getProductionCost().get(0).getCostColor() + " get 1 Faithpoint and 1 resource of your choice\n" +
                "Requirements: level 2 DevCard " + getCostCardLevelTwo() + "\n" +
                "VP: " + getVictoryPoints();
    }
    @Override
    public int getType() {
        return 4;
    }
}
//