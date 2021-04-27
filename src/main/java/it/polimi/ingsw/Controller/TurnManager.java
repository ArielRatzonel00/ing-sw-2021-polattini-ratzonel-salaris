package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;

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
        for (MarketMarble newresource : NewResources) {
            if (newresource.getColorMarble() == MarketMarble.ColorMarble.RED) {
                Currentplayer.getFaithTrack().setRedPosition(1);
            } else if (newresource.getColorMarble() == MarketMarble.ColorMarble.WHITE) {
                if (Currentplayer.getLeaderCards(0) instanceof LeaderCard1 && Currentplayer.getLeaderCards(0).isActivate()) {
                    if (Currentplayer.getLeaderCards(1) instanceof LeaderCard1 && Currentplayer.getLeaderCards(1).isActivate()) {
                        System.out.println("Choose between the color of resource of Leader Card 1 and the color of resource of LeaderCard2");
                        System.out.println("What do you want to do with this Marble");

                        // Crea nuova Marble con il colore scelto
                        // Decide se tenela o scartarla
                        // Chiama ChooseWhatToDoWithColoredMarble passando la riga dove vuole mettere la Marble e la Marble nuova. Se la riga è >= 6 vuol dire che la scarta

                    } else {
                        System.out.println("What do you want to do with this Marble");
                        // Crea nuova Marble con il colore in cui si trasforma la bianca, quello della LeaderCard
                        // Decide se tenela o scartarla
                        // Chiama ChooseWhatToDoWithColoredMarble passando la riga dove vuole mettere e la Marble nuova. Se la riga è >= a 6 vuol dire che la scarta

                    }
                } else if (Currentplayer.getLeaderCards(1) instanceof LeaderCard1 && Currentplayer.getLeaderCards(1).isActivate()) {
                    System.out.println("What do you want to do with this Marble");
                    // Crea nuova Marble con il colore in cui si trasforma la bianca, quello della LeaderCard
                    // Decide se tenela o scartarla
                    // Chiama ChooseWhatToDoWithColoredMarble passando la riga dove vuole mettere e la Marble nuova. Se la riga è >= a 6 vuol dire che la scarta

                } else {
                    // Niente
                }
            }
            else {
                System.out.println("What do you want to do with this Marble");
                // Decide se tenela o scartarla
                // Chiama ChooseWhatToDoWithColoredMarble passando la riga dove vuole mettere e la Marble
            }
        }
    }
    public void GetResourcesFromCol(int col,MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromCol(col);
        marketTray.ShiftMatrixByCol(col);
    }
    public boolean ChooseWhatToDoWithColoredMarble(int row, MarketMarble coloredMarble){
        if (row >= 6){
            for (Player otherplayer : OtherPlayers){
                otherplayer.getFaithTrack().setRedPosition(1);
            }
        }
        else{
            return Currentplayer.getWarehouse().addToRow(coloredMarble, row);
        }
        return true;
    }



    public void moveResourceFromWarehouse(int WarehouseRow1, int Warehouse2) {
        Currentplayer.getWarehouse().MoveResource(WarehouseRow1, Warehouse2);
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


    public boolean acquireCard( int cellRowNumber, int cellColNumber, int slot) {
        ArrayList<CostOfCard>  cost = developmentGrid.getSingleCell(cellRowNumber, cellColNumber).getTopCard().getCost();
        if (!(Currentplayer.CheckResourcesForAcquisition(cost))){
            return false;
        }

        //Quante risorse dallo Strongbox? andrà in ResourcesFromStrongbox
        //ArrayList<CostOfCard> ResourcesFromStrongbox

        // Quante risorse da ogni riga


        Currentplayer.getSlotsBoard().getSlots().get(slot - 1).addCard(developmentGrid.remove(cellRowNumber, cellColNumber));

        return true;
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

