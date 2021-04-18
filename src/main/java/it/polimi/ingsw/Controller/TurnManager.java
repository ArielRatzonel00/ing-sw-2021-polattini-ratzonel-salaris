package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;

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


        if (selectedResourcesCheck(card.getCost(),resourcesFromWarehouse,resourcesFromWarehouse)){ //check se le risorse passate sono sufficienti ad acquistare leader card
            //Try{
            player.getStrongbox().RemoveResourcesFromStrongbox(resoucesFromStrongbox);
            // DA FARE player.getWarehouse().RemoveResource(resourcesFromWarehouse);

            // } Catch (notEnoughResourcesException e)
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
        else
            System.out.println("You didn't select enough resources to acquire this card");
    }

    public boolean selectedResourcesCheck(int playerResources[], int strongBoxResources[], int warehouseResources[]){ // Funzione che controlla se la somma delle risorse selezionate i
        int flag=0;                                                                                                 //dallo strongbox e dal warehouse sono maggiori
        for(int i:strongBoxResources){                                                                               //di quelle richieste nel primo array passato
            if (playerResources[i]<=strongBoxResources[i]+warehouseResources[i])                                       //potremmo metterlo nelle EXCEPTIONS
                flag++;
        }
        if(flag==strongBoxResources.length)
            return true;
        else
            return false;
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

