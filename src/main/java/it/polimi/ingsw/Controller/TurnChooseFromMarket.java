package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.MarketMarble;
import it.polimi.ingsw.Model.MarketTray;
import it.polimi.ingsw.Model.Player;

import java.util.Arrays;

public class TurnChooseFromMarket {
   public void GetResourcesFromRow(int row, MarketTray marketTray, Player player){
       MarketMarble[] NewResources = new MarketMarble[4];
       NewResources = marketTray.GetMarketMarblesFromRow(row);
       marketTray.ShiftMatrixByRow(row);

       for (MarketMarble marketMarble : NewResources){
           if(marketMarble.getColorMarble() == MarketMarble.ColorMarble.WHITE){
               // vedere cosa succede con la leader card
           }
           else if (marketMarble.getColorMarble() == MarketMarble.ColorMarble.RED){
               player.getFaithTrack().setRedPosition(1);
           }
       }
    }
    public void moveResourceFromWarehouse(Player player, int From, int To){
        player.getWarehouse().moveResources(From, To);
    }
    public boolean CheckWarehouse(Player player){
       return player.getWarehouse().CheckWarehouse();
    }




}
// -
// - -
// - - -