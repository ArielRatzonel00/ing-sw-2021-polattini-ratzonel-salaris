package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.MarketMarble;
import it.polimi.ingsw.Model.MarketTray;

public class TurnChooseFromMarket {
   public void GetResourcesFromRow(int row, MarketTray marketTray){
       MarketMarble[] NewResources = new MarketMarble[4];
       NewResources = marketTray.GetMarketMarblesFromRow(row);
       marketTray.ShiftMatrixByRow(row);

       for (MarketMarble marketMarble : NewResources){
           if(marketMarble.getColorMarble() == MarketMarble.ColorMarble.WHITE){
               // vedere cosa succede con la leader card
           }


       }
    }




}
