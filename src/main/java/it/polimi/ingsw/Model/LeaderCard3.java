package it.polimi.ingsw.Model;

public class LeaderCard3 extends LeaderCard{ //extra warehouse




    public LeaderCard3(int id, int color1Cost, int color2, int specialAbilityColor, int victoryPoints) {
        super(id, color1Cost, color2, specialAbilityColor, victoryPoints);
    }

    @Override
    public boolean canBeActivated(Player player) {

        int[] TotalResourcesWarehouse = new int[4]; //0=purple, 1=blue, 2=yellow, 3=grey
        TotalResourcesWarehouse = player.getWarehouse().getTotalMaterials();

        if((this.getColor1Cost()==1 && TotalResourcesWarehouse[0] + player.getStrongbox().getServant() >=5) ||
                (this.getColor1Cost()==2 && TotalResourcesWarehouse[1] + player.getStrongbox().getShield() >=5) ||
                (this.getColor1Cost()==3 && TotalResourcesWarehouse[2] + player.getStrongbox().getCoin() >=5) ||
                (this.getColor1Cost()==4 && TotalResourcesWarehouse[3] + player.getStrongbox().getStone()>=5))
        {
            return true;
        }
        else {
            return false;
        }
    }
}
