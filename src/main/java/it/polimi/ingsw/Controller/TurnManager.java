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


    public void acquireCard(DevelopmentCard card, Player player, int n, int resoucesFromStrongbox[], int resourcesFromWarehouse[]) {
        //Try{
        player.getStrongbox().RemoveResourcesFromStrongbox(resoucesFromStrongbox);
        // DA FARE player.getWarehouse().RemoveResource(resourcesFromWarehouse);

        // } Catch (notEnoughResourcesException e)

        // IF for(int requirements : card.getCost())
        // devo controllare che la somma di ogni elemento di resourcesFromStrongbox[] e resourcesFromWarehouse[] sia maggiore del corrispndente elemento in
        // card.getCost()

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
    public boolean resourcesCheck(int strongBoxResources[], int WarehouseResources[]){
        for(int i: strongBoxResources){

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

