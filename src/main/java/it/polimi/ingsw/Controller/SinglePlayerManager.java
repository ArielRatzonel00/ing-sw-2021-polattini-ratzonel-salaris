package it.polimi.ingsw.Controller;

import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Observer.Observer;

import java.util.ArrayList;

public class SinglePlayerManager  {
    private SinglePlayerGame game;
    private Player player;


    public SinglePlayerManager(Player player) {
        player= player;
        game = new SinglePlayerGame(player);
        StartGame();
    }
    public void StartGame() {
        player.AssignFourLeaderCard(game.getDeck().getTopFourLeaderCard());

        // scegli quali LeaderCard scartare, settaNumeroScelto1, settaNumeroScelto2
        //player.DiscardLeaderCard(NumeroScelto1);
        //player.DiscardLeaderCard(NumeroScelto2);
    }
    public boolean PlayTurn(int type){
        boolean MoveResources = false;
        boolean FromRow = false;
        int num = 0;
        int cellrow = 0;
        int cellcol = 0;
        int slot = 0;
        int WarehouseRow1 = 0;
        int WarehouseRow2 = 0;
        boolean LeaderAction = false;
        int LeaderActionType = 0;
        ArrayList<CostOfCard> ProductionBasicCost = new ArrayList<>();
        ArrayList<CostOfCard> ProductionBasicProfit = new ArrayList<>();
        ArrayList<Integer> productions = new ArrayList<>();
        ArrayList<CostOfCard> ResourcesFromWarehosue = new ArrayList<>();
        ArrayList<Integer> Rows = new ArrayList<>();
        ArrayList<CostOfCard> ResourcesFromStrongbox = new ArrayList<>();
        MarketMarble.ColorMarble ProductionLeaderCardProfit = MarketMarble.ColorMarble.UNKNOWN;

        //Vuoi Muovere le tue risorse prima di iniziare il turno? setta MoveResouces
        if(MoveResources){
            //chiedi da che riga a che riga, setta WarehouseRow1 e WarehouseRow2
            if(!(moveResourceFromWarehouse(WarehouseRow1, WarehouseRow2))){
                System.out.println("Mossa non valida");
            }
        }
        //Vuoi fare un azione Leader prima del turno? setta LeaderAction
        // se si cosa? setta Leader ActionType
        if (LeaderAction){
            LeaderAction(LeaderActionType);
        }

        switch (type) {
            case 0: //Prendere le risorse dal MarketTray
                FromRow = false;
                 num = 0;
                //scegliere se da riga o da colonna e settare booleanFromRow
                //scegliere il numero di riga/colonna e settare num
                if (FromRow) {
                    GetResourcesFromRow(num, game.getMarketTray());
                } else {
                    GetResourcesFromCol(num, game.getMarketTray());
                }
                return true;

            case 1: // acquistare una carta
                cellrow = 0;
                cellcol = 0;
                slot = 0;
                // scegli la cella e setta cellrow e cellcol
                //sceglie in che slot metterla e setta slot

                if (!(acquireCard(cellrow, cellcol, slot))) {
                    return false;
                }


                //ScegliQualiRisorsePrendereDaWarehouse e setta ResourcesFromWarehouse
                //ScegliDaQualiRighePrenderle e setta Rows
                //ScegliQuanteRisorseDaStrongbox e setta ResourcesFromStrongbox
                // QUA IO AGGIUNGEREI IL CONTROLLO CHE CI SIANO QUESTE RISORSE NELLE RISPETTIVE RIGHE
                //FAREI ANCHE IL CONTROLLO CHE LA SOMMA DI QUELLO CHE PASSO ARRIVA EFETTIVAMENTE AL COSTO
                for (CostOfCard costOfCard : ResourcesFromStrongbox) {
                    player.getStrongbox().RemoveResourcesFromStrongbox(costOfCard.getCostNumber(), costOfCard.getCostColor());
                }
                //RimuoviAncheDaWarehouse
                return true;

            case 2: //Attivare la produzione

                //scegliere le produzioni da attivare e setta productions
                if (productions.contains(0)){
                    // Per la produzione base di che colore vuoi che siano le prime due palline? setta ProductionBasicCost
                    // Quale profitto vuoi ottenere? setta ProductionBasicProfit
                    player.getProductionsAvaible().get(0).setProductionCost(ProductionBasicCost);
                    player.getProductionsAvaible().get(0).setProductionCost(ProductionBasicProfit);
                }
                for (Integer i : productions) {
                    if (player.getProductionsAvaible().get(i) == null || !(player.CheckResourcesForProduce(player.getProductionsAvaible().get(i).getProductionCost()))) {
                        return false;
                    }
                }
                if (productions.contains(4)){
                    if (player.getProductionsAvaible().get(4).getProductionProfit().size()>1) {
                        player.getProductionsAvaible().get(4).getProductionProfit().remove(1);
                    }
                    //Scegli che risorsa ottenere dalla produzione della LeaderCard
                    //setta ProductionLeaderCardProfit
                    player.getProductionsAvaible().get(4).getProductionProfit().add(new CostOfCard(1,ProductionLeaderCardProfit));
                }
                if (productions.contains(5)){
                    if (player.getProductionsAvaible().get(5).getProductionProfit().size()>1) {
                        player.getProductionsAvaible().get(5).getProductionProfit().remove(1);
                    }
                    //Scegli che risorsa ottenere dalla produzione della LeaderCard
                    //setta ProductionLeaderCardProfit
                    player.getProductionsAvaible().get(5).getProductionProfit().add(new CostOfCard(1,ProductionLeaderCardProfit));
                }
                for (Integer i : productions) {

                    //Chiedo quanti da Warehouse, da che riga e quanti da Strongbox
                    //setta ResourcesFromWarehosue
                    //setta Rows
                    //setta ResoucesFromStrongbox
                    player.getProductionsAvaible().get(i).Produce(ResourcesFromWarehosue, Rows, ResourcesFromStrongbox, player);
                }
                return true;

        }
        //Vuoi fare un azione Leader dopo il turno? setta LeaderAction se si cosa? setta Leader ActionType
        if (LeaderAction){
            LeaderAction(LeaderActionType);
        }
        game.getMarkers().getTopMarker().MarkerEffect(player,game);
        return true;



    }







    public void endGame(boolean LorenzoWon) {
        if (LorenzoWon) {
            System.out.println("Il vincitore è Lorenzo il Magnifico, hai perso!");
        }
        else {
            System.out.println("Hai vinto! Hai totalizzato questo punteggio: " + player.GetTotalPoints());
        }
    }
    public void GetResourcesFromRow(int row, MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromRow(row);
        marketTray.ShiftMatrixByRow(row);
        EffectOfTheNewResources(NewResources);
    }
    public void GetResourcesFromCol(int col,MarketTray marketTray) {
        MarketMarble[] NewResources = marketTray.GetMarketMarblesFromCol(col);
        marketTray.ShiftMatrixByCol(col);
        EffectOfTheNewResources(NewResources);
    }
    public void EffectOfTheNewResources(MarketMarble[] newResources){
        for (MarketMarble newresource : newResources) {
            if (newresource.getColorMarble() == MarketMarble.ColorMarble.RED) {
                player.getFaithTrack().setRedPosition(1);
            } else if (newresource.getColorMarble() == MarketMarble.ColorMarble.WHITE) {
                if (player.getLeaderCard(0) instanceof LeaderCard1 && player.getLeaderCard(0).isActivate()) {
                    if (player.getLeaderCard(1) instanceof LeaderCard1 && player.getLeaderCard(1).isActivate()) {
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
                } else if (player.getLeaderCard(1) instanceof LeaderCard1 && player.getLeaderCard(1).isActivate()) {
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
                // Chiama ChooseWhatToDoWithColoredMarble passando la riga dove vuole mettere e la Marble Se la riga è >= a 6 vuol dire che la scarta
            }
        }

    }
    public void ChooseWhatToDoWithColoredMarble(int row, MarketMarble coloredMarble){
        if (row >= 6){
            player.getFaithTrack().setBlackPosition(1);
        }
        else{
            if(!(player.getWarehouse().addToRow(coloredMarble, row))){
                player.getFaithTrack().setBlackPosition(1);
            }
        }

    }
    public boolean acquireCard( int cellRowNumber, int cellColNumber, int slot) {
        ArrayList<CostOfCard> cost = game.getDevelopmentGrid().getSingleCell(cellRowNumber, cellColNumber).getTopCard().getCost();
        if (!(player.CheckResourcesForAcquisition(cost))) {
            return false;
        }
        if (!player.getSlotsBoard().getSlots().get(slot - 1).CanBeAddedInTheSlot(game.getDevelopmentGrid().get(cellRowNumber, cellColNumber))) {
            return false;
        }
        return true;
    }
    public boolean moveResourceFromWarehouse(int WarehouseRow1, int Warehouse2) {
        return player.getWarehouse().MoveResource(WarehouseRow1, Warehouse2);
    }
    public void LeaderAction(int LeaderActionType){
        int LeaderCard = 0;
        switch (LeaderActionType){
            case 0: // attivare solo una carta Leader
                //Che carta Leader vuoi attivare? setta Leader Card
                if (player.getLeaderCard(LeaderCard).canBeActivated(player)){
                    player.getLeaderCard(LeaderCard).setActivate(true);
                    player.getLeaderCard(LeaderCard).effect(player);
                }
            case 1: // Scartare solo una carta Leader
                //Che carta Leader vuoi scartare? setta Leader Card
                if (player.getLeaderCard(LeaderCard).isActivate()){
                    System.out.println("Non puoi scartare questa carta Leader perchè è stata giocata");
                }
                else {
                    player.DiscardLeaderCard(LeaderCard);
                    player.getFaithTrack().setBlackPosition(1);
                }
            case 2: // attivare solo una carta Leader e scartarne una
                //Che carta Leader vuoi attivare? setta Leader Card
                if (player.getLeaderCard(LeaderCard).canBeActivated(player)){
                    player.getLeaderCard(LeaderCard).setActivate(true);
                    player.getLeaderCard(LeaderCard).effect(player);
                }
                //Che carta Leader vuoi scartare? setta Leader Card
                if (player.getLeaderCard(LeaderCard).isActivate()){
                    System.out.println("Non puoi scartare questa carta Leader perchè è stata giocata");
                }
                else {
                    player.DiscardLeaderCard(LeaderCard);
                    player.getFaithTrack().setBlackPosition(1);
                }
            case 3: //attivare due carte Leader

                if (player.getLeaderCard(0).canBeActivated(player)){
                    player.getLeaderCard(0).setActivate(true);
                    player.getLeaderCard(0).effect(player);
                }
                if (player.getLeaderCard(1).canBeActivated(player)){
                    player.getLeaderCard(1).setActivate(true);
                    player.getLeaderCard(1).effect(player);
                }
            case 4: // scartare due carte Leader
                if (player.getLeaderCard(0).isActivate()){
                    System.out.println("Non puoi scartare la prima carta Leader perchè è stata giocata");
                }
                else {
                    player.DiscardLeaderCard(0);
                    player.getFaithTrack().setBlackPosition(1);
                }
                if (player.getLeaderCard(1).isActivate()){
                    System.out.println("Non puoi scartare la seconda carta Leader perchè è stata giocata");
                }
                else {
                    player.DiscardLeaderCard(1);
                    player.getFaithTrack().setBlackPosition(1);
                }

        }
    }

    public SinglePlayerGame getGame() {
        return game;
    }
}


