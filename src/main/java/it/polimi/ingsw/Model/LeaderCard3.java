package it.polimi.ingsw.Model;

public class LeaderCard3 extends LeaderCard{ //extra warehouse

    public LeaderCard3(int id, int color1Cost, int color2, int specialAbilityColor, int victoryPoints) {
        super(id, color1Cost, color2, specialAbilityColor, victoryPoints);
    }

    @Override
    public boolean canBeActivated(Player player) {
        return true;
    }
}
