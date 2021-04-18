package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.Player;

public class LeaderCard4 extends LeaderCard{ //converte in punto fede e materia a caso -> produzione extra

    public LeaderCard4(int id, int color1Cost, int color2, int specialAbilityColor, int victoryPoints) {
        super(id, color1Cost, color2, specialAbilityColor, victoryPoints);
    }

    public boolean canBeActivated(Player player) {
        if(player.getSlots().getDevCardsLevel2(this.getColor1Cost()) == true){
            return true;
        }
        else {
            return false;
        }
    }
}
