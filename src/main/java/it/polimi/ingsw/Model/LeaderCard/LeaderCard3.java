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


        int TotalResourcesWarehouse=player.getWarehouse().getNumberOfResource(ColorCost);
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
