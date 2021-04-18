package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.Player;

public class LeaderCard1 extends LeaderCard { //metodo per leader cards che trasformano pallina bianca in altri colori


    private int[] SlotCards = new int[4];

    public LeaderCard1(int id, int color1Cost, int color2, int specialAbilityColor ,int victoryPoints) {
        super(id, color1Cost, color2, specialAbilityColor, victoryPoints);

    }

    @Override
    public boolean canBeActivated(Player player) {
        SlotCards = player.getSlots().getNumberOfDevCardsForColors();
        if((this.getColor1Cost()==1 && SlotCards[0]>=2 && this.getColor2()==4 && SlotCards[3]>=1) ||
                (this.getColor1Cost()==4 && SlotCards[3]>=2 && this.getColor2()==1 && SlotCards[0]>=1) ||
                (this.getColor1Cost()==3 && SlotCards[2]>=2 && this.getColor2()==2 && SlotCards[1]>=1) ||
                (this.getColor1Cost()==2 && SlotCards[1]>=2 && this.getColor2()==3 && SlotCards[2]>=1))
                {
            return true;
        }
        else {
            return false;
        }

    }
}
