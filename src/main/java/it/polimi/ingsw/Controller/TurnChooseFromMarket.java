package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.MarketMarble;
import it.polimi.ingsw.Model.MarketTray;
import it.polimi.ingsw.Model.Player;

import java.util.Arrays;

public class TurnChooseFromMarket {
   public void GetResourcesFromRow(int row, MarketTray marketTray, Player player){
       MarketMarble[] NewResources;
       NewResources = marketTray.GetMarketMarblesFromRow(row);
       marketTray.ShiftMatrixByRow(row);

       for (MarketMarble marketMarble : NewResources){
           marketMarble.EffectOfMarble(player);
           }
       }

    public void moveResourceFromWarehouse(Player player, int From, int To){
        player.getWarehouse().moveResources(From, To);
    }



}
// -
// - -
// - - -