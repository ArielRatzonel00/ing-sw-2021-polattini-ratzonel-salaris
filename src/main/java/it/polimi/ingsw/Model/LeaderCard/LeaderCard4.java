package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.Production;



public class LeaderCard4 extends LeaderCard{ //converte in punto fede e materia a caso -> produzione extra
    private DevelopmentCard.colorCard CostCardLevelTwo;
    private Production production;

    public LeaderCard4(int id, DevelopmentCard.colorCard CostCardLevelTwo, int victoryPoints, Production production) {
        super(id, victoryPoints);
        this.CostCardLevelTwo = CostCardLevelTwo;
        this.production = production;
    }

    public boolean canBeActivated(Player player) {
        return player.getSlotsBoard().filterCount(CostCardLevelTwo, 2) >= 1;
    }

    public DevelopmentCard.colorCard getCostCardLevelTwo() {
        return CostCardLevelTwo;
    }

    public Production getProduction () {
        return production;
    }
    public void effect(Player player){
        player.newProductionFromLeaderCard(production);
    }

    /*public void effect(){
        DevCardSlot leaderSlot = new DevCardSlot();
        DevelopmentCard LeaderDevelopment = new DevelopmentCard(0,);

        leaderSlot.addCard();
        slotsboard.addSlot();
    }
    */
}
//