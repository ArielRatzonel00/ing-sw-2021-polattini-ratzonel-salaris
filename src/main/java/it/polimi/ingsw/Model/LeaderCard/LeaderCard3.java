package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Player;

import java.util.ArrayList;

public class LeaderCard3 extends LeaderCard{ //extra warehouse


private ColoredMarble.ColorMarble ColorCost;
private int NumberCost = 5;
private ColoredMarble.ColorMarble colorOfExtraWarehouse;
private ArrayList<ColoredMarble> ExtraRow;



    public LeaderCard3(int id, int victoryPoints, ColoredMarble.ColorMarble colorCost, ColoredMarble.ColorMarble ColorOfExtraWarehouse) {
        super(id, victoryPoints);
        this.ColorCost = colorCost;
        this.colorOfExtraWarehouse = ColorOfExtraWarehouse;
    }

    @Override
    public boolean canBeActivated(Player player) {


        int TotalResourcesWarehouse = 0;
        if(ColorCost == player.getWarehouse().getColorrow1()){
            TotalResourcesWarehouse = 1;
        }
        else if (ColorCost == player.getWarehouse().getColorrow2()){
            TotalResourcesWarehouse = player.getWarehouse().getRow2().size();
        }
        else if (ColorCost == player.getWarehouse().getColorrow3()){
            TotalResourcesWarehouse = player.getWarehouse().getRow3().size();
        }
        if (player.getLeaderCards(0) != null && player.getLeaderCards(0).isActivate() && player.getLeaderCards(0) instanceof LeaderCard3 ) {
            if (((LeaderCard3) player.getLeaderCards(0)).colorOfExtraWarehouse.equals(ColorCost)) {
                TotalResourcesWarehouse +=  ((LeaderCard3) player.getLeaderCards(0)).getExtraRow().size();
            }
        }
        else if (player.getLeaderCards(1) != null && player.getLeaderCards(1).isActivate() && player.getLeaderCards(1) instanceof LeaderCard3 ){
            if (((LeaderCard3) player.getLeaderCards(1)).colorOfExtraWarehouse.equals(ColorCost)) {
                TotalResourcesWarehouse += ((LeaderCard3) player.getLeaderCards(1)).getExtraRow().size();
            }
        }

        int TotalResourcesInStrongbox = player.getStrongbox().CountResources(ColorCost);

        if(TotalResourcesInStrongbox + TotalResourcesWarehouse >= 5)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<ColoredMarble> getExtraRow() {
        return ExtraRow;
    }

    public ColoredMarble.ColorMarble getColorCost() {
        return ColorCost;
    }

    public int getNumberCost() {
        return NumberCost;
    }

    public ColoredMarble.ColorMarble getColorOfExtraWarehouse() {
        return colorOfExtraWarehouse;
    }
}
