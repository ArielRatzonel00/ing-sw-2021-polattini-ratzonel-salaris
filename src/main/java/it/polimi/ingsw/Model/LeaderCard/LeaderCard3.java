package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.WarehouseRow;

import java.util.ArrayList;

public class LeaderCard3 extends LeaderCard{ //extra warehouse


private MarketMarble.ColorMarble ColorCost;
private int NumberCost = 5;
private MarketMarble.ColorMarble colorOfExtraWarehouse;
private ArrayList<MarketMarble> ExtraRow;



    public LeaderCard3(int id, int victoryPoints, MarketMarble.ColorMarble colorCost, MarketMarble.ColorMarble ColorOfExtraWarehouse) {
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
    public ArrayList<MarketMarble> getExtraRow() {
        return ExtraRow;
    }

    public MarketMarble.ColorMarble getColorCost() {
        return ColorCost;
    }

    public int getNumberCost() {
        return NumberCost;
    }

    public MarketMarble.ColorMarble getColorOfExtraWarehouse() {
        return colorOfExtraWarehouse;
    }
    public void effect(Player player){
        player.getWarehouse().getRows().add(new WarehouseRow(2));
        player.getWarehouse().getRows().get(player.getWarehouse().getRows().size()-1).setColor(colorOfExtraWarehouse);


    }
}
