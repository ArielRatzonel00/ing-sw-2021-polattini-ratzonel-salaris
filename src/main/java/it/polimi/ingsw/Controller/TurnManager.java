package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;

public class TurnManager {
    Player player;

    public TurnManager(Player player) {
        this.player = player;
    }

    //Funzioni che chiamano le funzioni delle classe del model
    public void GetResourcesFromRow(int row, MarketTray marketTray, Player player) {
        MarketMarble[] NewResources;
        NewResources = marketTray.GetMarketMarblesFromRow(row);
        marketTray.ShiftMatrixByRow(row);

        for (MarketMarble marketMarble : NewResources) {
            marketMarble.EffectOfMarble(player);
        }
    }

    public void moveResourceFromWarehouse(Player player, int From, int To) {
        player.getWarehouse().moveResources(From, To);
    }


    public void acquireCard(DevelopmentCard card, int n, int resoucesFromStrongbox[], int resourcesFromWarehouse[]) {
        //int selectedResources[4]=somma(resourcesFromWarehouse,resoucesFromStrongox);
        //controllo che player abbia effettivamente le risorse in strongbox e Warehouse.
        // chiami il metodo checkresourcesFromStrongbox
        // chiami CheckResourcesFromWarehoues
        //CheckIfResourcesAreEnough
        if (n == 1) {
            player.getSlots().addSlot1(card);

        }
        if (n == 2) {
            player.getSlots().addSlot2(card);
        }
        if (n == 3) {

            player.getSlots().addSlot2(card);
        }

    }
    public void discardLeaderCard(int num) {
        player.DiscardLeaderCard(num);
        player.getFaithTrack().setRedPosition(1);
    }
    public void activateLeaderCard(int num) {
        if (player.getLeaderCards(num).canBeActivated(player) == true) {
            player.getLeaderCards(num).setActivate(true);
        }
    }
    //public void productionByDevCard
    //
}
//Aggiungere Production

