package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;

public class TurnManager {
    private Player Currentplayer;
    private ArrayList<Player> OtherPlayers;

    public TurnManager(Player currentplayer) {
        this.Currentplayer = currentplayer;
    }

    //Funzioni che chiamano le funzioni delle classe del model
    public void GetResourcesFromRow(int row,boolean[] Keep, MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromRow(row);
        marketTray.ShiftMatrixByRow(row);

        for (int i = 0; i < 3; i++) {
            if (Keep[i] == true) {
                NewResources[i].EffectOfMarble(Currentplayer);
            } else {
                for (Player otherplayer : OtherPlayers) {
                    otherplayer.getFaithTrack().setRedPosition(1); // devo farlo per tutti i players che non sono io
                }
            }
        }
    }
    public void GetResourcesFromCol(int col,boolean[] Keep, MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromCol(col);
        marketTray.ShiftMatrixByCol(col);

        for (int i = 0; i < 4; i++) {
            if (Keep[i] == true) {
                NewResources[i].EffectOfMarble(Currentplayer);
            } else {
                for (Player otherplayer : OtherPlayers) {
                    otherplayer.getFaithTrack().setRedPosition(1); // devo farlo per tutti i players che non sono io
                }

            }
        }
    }


    public void moveResourceFromWarehouse(Player player, int From, int To) {
        player.getWarehouse().moveResources(From, To);
    }


    public void acquireCard(DevelopmentCard card, int n, int resoucesFromStrongbox[], int resourcesFromWarehouse[]) {


        if (selectedResourcesCheck(card.getCost(),resourcesFromWarehouse,resourcesFromWarehouse)){ //check se le risorse passate sono sufficienti ad acquistare leader card
            //Try{
            Currentplayer.getStrongbox().RemoveResourcesFromStrongbox(resoucesFromStrongbox);
            // DA FARE player.getWarehouse().RemoveResource(resourcesFromWarehouse);

            // } Catch (notEnoughResourcesException e)
            if (n == 1) {
                Currentplayer.getSlots().addSlot1(card);

            }
            if (n == 2) {
                Currentplayer.getSlots().addSlot2(card);
            }
            if (n == 3) {

                Currentplayer.getSlots().addSlot2(card);
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
        Currentplayer.DiscardLeaderCard(num);
        Currentplayer.getFaithTrack().setRedPosition(1);
    }
    public void activateLeaderCard(int num) {
        if (Currentplayer.getLeaderCards(num).canBeActivated(Currentplayer) == true) {
            Currentplayer.getLeaderCards(num).setActivate(true);
        }
    }
    //public void productionByDevCard
    //
}
//Aggiungere Production

