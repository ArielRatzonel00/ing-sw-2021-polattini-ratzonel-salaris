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
import java.util.stream.Collectors;

public class TurnManager {
    private Player Currentplayer;
    private ArrayList<Player> OtherPlayers = new ArrayList<>();
    private Deck deck =new Deck();
    private DevelopmentGrid developmentGrid=new DevelopmentGrid(deck);

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


    public boolean selectedResourcesCheck(ArrayList<CostOfCard> cost, ArrayList<CostOfCard>  strongBoxResources, ArrayList<CostOfCard> resourcesFromWarehouse){ // Funzione che controlla se la somma delle risorse selezionate i dallo strongbox e dal warehouse sono maggiori di quelle richieste nel primo array passato


        for(CostOfCard costOfCard : cost){
            int costNumber = costOfCard.getCostNumber();
            int ResouceNumber = 0;
            int StrongboxNumber = 0;

            // CostOfCard one = strongBoxResources.stream().filter(a->a.getCostColor().equals(costOfCard.getCostColor())).collect(Collectors.toList()).get(0);
            for (CostOfCard costOfCard1 : strongBoxResources){
                if (costOfCard.getCostColor() == costOfCard1.getCostColor()){
                    StrongboxNumber = costOfCard1.getCostNumber();
                }
            }
            for (CostOfCard costOfCard2 : resourcesFromWarehouse){
                if (costOfCard.getCostColor() == costOfCard2.getCostColor()){
                    ResouceNumber = costOfCard2.getCostNumber();
                }
            }
            if (costNumber > ResouceNumber + StrongboxNumber){
                return false;
            }

            }
        return true;
        }


    public boolean acquireCard( int cellRowNumber, int cellColNumber, int slot, ArrayList<CostOfCard> resoucesFromStrongbox,ArrayList<CostOfCard> resourcesFromWarehouse) {
        int[] cost= developmentGrid.getSingleCell(cellRowNumber,cellColNumber).getTopCard().getCost();
        if(selectedResourcesCheck(cost,resoucesFromStrongbox,resourcesFromWarehouse)) {
            for (CostOfCard costOfCard : resoucesFromStrongbox){
                if (costOfCard.getCostNumber() > Currentplayer.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
            for (CostOfCard costOfCard: resourcesFromWarehouse){
                if (costOfCard.getCostNumber() > Currentplayer.getStrongbox().CountResources(costOfCard.getCostColor())){
                    return false;
                }
            }
            // mi metto in attesa dei comandi del player che mi da per ogni riga quante risorse eliminare e faccio il controllo che corrispondono con resourcesFromWarehouse
            // anzi no faccio direttamente che passo le righe e creo il mio resources From Warehouse in base alle righe che passo
            for (CostOfCard costOfCard : resourcesFromWarehouse){
            Currentplayer.getStrongbox().RemoveResourcesFromStrongbox(costOfCard.getCostNumber(), costOfCard.getCostColor());


            }

            Currentplayer.getSlotsBoard().getSlots().get(slot-1).addCard(developmentGrid.remove(cellRowNumber, cellColNumber));

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

