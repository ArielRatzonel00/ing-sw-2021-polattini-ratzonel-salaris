package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Marble.RedMarble;
import it.polimi.ingsw.Model.Marble.WhiteMarble;
import java.io.*;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;

public class TurnManager {
    private Player Currentplayer;
    private ArrayList<Player> OtherPlayers;

    public TurnManager(Player currentplayer) {
        this.Currentplayer = currentplayer;
    }

    //Funzioni che chiamano le funzioni delle classe del model

    //WarwhouseRow:
    // il valore 0 corrisponde al niente(quindi bianche(che non diventano di un altro colore) e rosse)
    // il valore 1 corrisponde alla riga 1 del Warehouse
    //il valore 2 corrisponde alla riga 2 del Warehouse
    // il valore 3 corrisponed alla riga 3 del Warehouse
    // il valore 4 corrisponde alla rigaExtra1 attivata dalla LeaderCard1
    //il valore 5 corrisponde alla rigaExtra2 attivata dalla LeaderCard2
    // il valore 6 corrisponde al discard
    public void GetResourcesFromRow(int row,MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromRow(row);
        marketTray.ShiftMatrixByRow(row);
        for (MarketMarble newresource : NewResources ){
            if (newresource instanceof RedMarble){
                Currentplayer.getFaithTrack().setRedPosition(1);
            }
            else if (newresource instanceof ColoredMarble) {
                System.out.println("What do you want to do with this Marble");
               //Utente Clicca Bottone che chiama choose what to do whith colored Card
            }
            else if(newresource instanceof WhiteMarble){
                if(Currentplayer.getLeaderCards(0).isActivate() && Currentplayer.getLeaderCards(0) instanceof LeaderCard1){
                    if(!Currentplayer.getLeaderCards(1).isActivate() || !(Currentplayer.getLeaderCards(1) instanceof LeaderCard1)){
                        System.out.println("What do you want to do with this Marble");
                    }
                    else if(Currentplayer.getLeaderCards(1).isActivate() && (Currentplayer.getLeaderCards(1) instanceof LeaderCard1)){
                        System.out.println("What do you want to do with this Marble and in which marble you want to Transform");
                    }
                }
                else if (Currentplayer.getLeaderCards(1).isActivate() && (Currentplayer.getLeaderCards(1) instanceof LeaderCard1)){
                    System.out.println("What do you want to do with this Marble");
                }
                else {
                    //Nothing
                }
            }
        }
    }
    public void GetResourcesFromCol(int col,MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromCol(col);
        marketTray.ShiftMatrixByCol(col);
    }
    public void ChooseWhatToDoWithColoredMarble(boolean keep, ColoredMarble coloredMarble){
        if (keep){
            //ASPETTO CHE L'UTENTE MI PASSI RIGA(WarehouseRow) IN CUI METTERE PALLINA E FACCIO ADDTOROW
            // Currentplayer.getWarehouse().addToRow(coloredMarble,WarehouseRow);
        }
        else{
            //otherplayers.faithTrak.setRedPosition
        }
    }



    public void moveResourceFromWarehouse(Player player, int WarehouseRow1, int Warehouse2) {
        player.getWarehouse().MoveResource(WarehouseRow1, Warehouse2);
    }


    public void acquireCard(DevelopmentCard card, int n, int resoucesFromStrongbox[], int resourcesFromWarehouse[]) {


        if (selectedResourcesCheck(card.getCost(),resourcesFromWarehouse,resourcesFromWarehouse)){ //check se le risorse passate sono sufficienti ad acquistare leader card
            //Try{
            Currentplayer.getStrongbox().RemoveResourcesFromStrongbox(resoucesFromStrongbox);
            // DA FARE player.getWarehouse().RemoveResource(resourcesFromWarehouse);

            // } Catch (notEnoughResourcesException e)

                Currentplayer.getSlotsBoard().getSlots().get(n-1).addCard(card);
            }

        else
            System.out.println("You didn't select enough resources to acquire this card");
    }

    public boolean selectedResourcesCheck(int[] playerResources, int[] strongBoxResources, int[] warehouseResources){ // Funzione che controlla se la somma delle risorse selezionate i
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

