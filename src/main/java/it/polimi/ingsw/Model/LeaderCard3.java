package it.polimi.ingsw.Model;

public class LeaderCard3 extends LeaderCard{ //extra warehouse

    private int[] TotalResources = new int[4]; //0=purple, 1=blue, 2=yellow, 3=grey


    public LeaderCard3(int id, int color1Cost, int color2, int specialAbilityColor, int victoryPoints) {
        super(id, color1Cost, color2, specialAbilityColor, victoryPoints);
    }

    @Override
    public boolean canBeActivated(Player player) {
        TotalResources = player.getWarehouse().getTotalMaterials();

        TotalResources[0] = player.getStrongbox().getServant();
        TotalResources[1] = player.getStrongbox().getShield();
        TotalResources[2] = player.getStrongbox().getCoin();
        TotalResources[3] = player.getStrongbox().getStone();

        if((this.getColor1Cost()==1 && TotalResources[0]>=5) ||
                (this.getColor1Cost()==2 && TotalResources[1]>=5) ||
                (this.getColor1Cost()==3 && TotalResources[2]>=5) ||
                (this.getColor1Cost()==4 && TotalResources[3]>=5))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
