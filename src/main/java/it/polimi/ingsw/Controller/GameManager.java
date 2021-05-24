package it.polimi.ingsw.Controller;
import it.polimi.ingsw.Model.*;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Network.Messages.*;
import it.polimi.ingsw.Network.Server.VirtualView;
import it.polimi.ingsw.Observer.ControllerObserver;
import it.polimi.ingsw.Observer.Observable;

import java.io.IOException;
import java.util.*;


public class GameManager extends Observable<Model> implements ControllerObserver<VirtualView> {
    private Model game;
    private Player CurrentPlayer;
    private ArrayList<Player> OtherPlayers;
    private boolean IsSinglePlayer = false;
    private boolean FinishGame = false;
    private int a;

    public GameManager(Model game) {
        this.game = game;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        IsSinglePlayer = singlePlayer;
    }

    @Override
    public void updateAssignFourLeaderCards(FourLeaderCardsMessage fourLeaderCardsMessage) {
        game.AssignFourLeaderCards(fourLeaderCardsMessage.getPlayerIndex());
    }

    public void updateDiscardLeaderCards(DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage) {
        game.DiscardInitialLeaderCards(discardInitialLeaderCardsMessage.getPlayerIndex(), discardInitialLeaderCardsMessage.getIndexLeaderCard1(), discardInitialLeaderCardsMessage.getIndexLeaderCard2() - 1);
    }

    public void updateInitialResource(InitialResourcesMessage initialResourcesMessage) {
        if (initialResourcesMessage.getPlayerIndex() == 1) {
            game.SetInitialResourcesForSecondPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1());
        } else if (initialResourcesMessage.getPlayerIndex() == 2) {
            game.SetInitialResourcesForThirdPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1());
        } else if (initialResourcesMessage.getPlayerIndex() == 3) {
            game.SetInitialResourcesForForthPlayer(initialResourcesMessage.getColorMarble1(), initialResourcesMessage.getRow1(), initialResourcesMessage.getColorMarble2(), initialResourcesMessage.getRow2());
        }
    }

    public void updateWantToBuyCard(WantToBuyCardMessage wantToBuyCardMessage) {
        game.WantToBuyCard(wantToBuyCardMessage.getPlayerIndex(), wantToBuyCardMessage.getRow(), wantToBuyCardMessage.getCol(), wantToBuyCardMessage.getSlot());
    }

    public void updateBuyCard(BuyCardMessage buyCardMessage) {
        game.BuyCard(buyCardMessage.getPlayerIndex(), buyCardMessage.getResourcesFromStrongbox(), buyCardMessage.getResourcesFromWarehouse(), buyCardMessage.getRows(), buyCardMessage.getCellrow(), buyCardMessage.getCellcol(), buyCardMessage.getSlot());
    }

    public void updateMarketTrayAction(MarketTrayActionMessage marketTrayActionMessage) {
        game.MarketTrayAction(marketTrayActionMessage.isRow(), marketTrayActionMessage.getIndex());
    }

    public void updateDealWithAResourceFromMarketTray(DealWithAResourceFromMarketTrayMessage dealWithAResourceFromMarketTrayMessage) {
        game.DealWithAResource(dealWithAResourceFromMarketTrayMessage.getPlayerIndex(), dealWithAResourceFromMarketTrayMessage.isKeep(), dealWithAResourceFromMarketTrayMessage.getMarble(), dealWithAResourceFromMarketTrayMessage.getRowOfTheWarehouse());
    }

    public void updateMoveResources(MoveResourcesMessage moveResourcesMessage) {
        game.MoveResources(moveResourcesMessage.getPlayerIndex(), moveResourcesMessage.getRow1(), moveResourcesMessage.getRow2());
    }

    public void updateWantActivateProduction(WantActivateProductionMessage wantActivateProductionMessage) {
        game.CanProduce(wantActivateProductionMessage.getPlayerIndex(), wantActivateProductionMessage.getProductions(), wantActivateProductionMessage.getProductionBasicCost());
    }

    public void updateProduce(ProduceMessage produceMessage) {
        int last1 = produceMessage.getProductions().size() - 1;
        boolean last2 = false;
        for (int i : produceMessage.getProductions()) {
            if (i == last1) {
                last2 = true;
            }
            switch (i) {
                case 0 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox0(), produceMessage.getResourcesFromWarehouse0(), produceMessage.getRows0(), last2);
                case 1 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox1(), produceMessage.getResourcesFromWarehouse1(), produceMessage.getRows1(), last2);
                case 2 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox2(), produceMessage.getResourcesFromWarehouse2(), produceMessage.getRows2(), last2);
                case 3 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox3(), produceMessage.getResourcesFromWarehouse3(), produceMessage.getRows3(), last2);
                case 4 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox4(), produceMessage.getResourcesFromWarehouse4(), produceMessage.getRows4(), last2);
                case 5 -> game.Produce(produceMessage.getPlayerIndex(), produceMessage.getResourcesFromStrongbox5(), produceMessage.getResourcesFromWarehouse5(), produceMessage.getRows5(), last2);
            }
        }
    }

    public void updateDiscardLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage) {
        game.DiscardLeaderCardAction(leaderCardActionMessage.getPlayerIndex(), leaderCardActionMessage.getNLeaderCard());
    }

    public void updateActivateLeaderCardAction(LeaderCardActionMessage leaderCardActionMessage) {
        game.ActivateLeaderCardAction(leaderCardActionMessage.getPlayerIndex(), leaderCardActionMessage.getNLeaderCard());
    }

    public void updateEndOfTurn(EndOfTurnMessage endOfTurnMessage) {
        game.EndTurn(endOfTurnMessage.getPlayerIndex());
    }
}






/*
  public boolean PlayTurn(int type) {
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

 */
    /*
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
                    CurrentPlayer.getStrongbox().RemoveResourcesFromStrongbox(costOfCard.getCostNumber(), costOfCard.getCostColor());
                }
                //RimuoviAncheDaWarehouse
                return true;

            case 2: //Attivare la produzione

                //scegliere le produzioni da attivare e setta productions
                if (productions.contains(0)){
                    // Per la produzione base di che colore vuoi che siano le prime due palline? setta ProductionBasicCost
                    // Quale profitto vuoi ottenere? setta ProductionBasicProfit
                    CurrentPlayer.getProductionsAvaible().get(0).setProductionCost(ProductionBasicCost);
                    CurrentPlayer.getProductionsAvaible().get(0).setProductionCost(ProductionBasicProfit);
                }
                for (Integer i : productions) {
                    if (CurrentPlayer.getProductionsAvaible().get(i) == null || !(CurrentPlayer.CheckResourcesForProduce(CurrentPlayer.getProductionsAvaible().get(i).getProductionCost()))) {
                        return false;
                    }
                }
                if (productions.contains(4)){
                    if (CurrentPlayer.getProductionsAvaible().get(4).getProductionProfit().size()>1) {
                        CurrentPlayer.getProductionsAvaible().get(4).getProductionProfit().remove(1);
                    }
                    //Scegli che risorsa ottenere dalla produzione della LeaderCard
                    //setta ProductionLeaderCardProfit
                    CurrentPlayer.getProductionsAvaible().get(4).getProductionProfit().add(new CostOfCard(1,ProductionLeaderCardProfit));
                }
                if (productions.contains(5)){
                    if (CurrentPlayer.getProductionsAvaible().get(5).getProductionProfit().size()>1) {
                        CurrentPlayer.getProductionsAvaible().get(5).getProductionProfit().remove(1);
                    }
                    //Scegli che risorsa ottenere dalla produzione della LeaderCard
                    //setta ProductionLeaderCardProfit
                    CurrentPlayer.getProductionsAvaible().get(5).getProductionProfit().add(new CostOfCard(1,ProductionLeaderCardProfit));
                }
                for (Integer i : productions) {

                    //Chiedo quanti da Warehouse, da che riga e quanti da Strongbox
                    //setta ResourcesFromWarehosue
                    //setta Rows
                    //setta ResoucesFromStrongbox
                    CurrentPlayer.getProductionsAvaible().get(i).Produce(ResourcesFromWarehosue, Rows, ResourcesFromStrongbox, CurrentPlayer);
                }
                return true;

        }
        //Vuoi fare un azione Leader dopo il turno? setta LeaderAction se si cosa? setta Leader ActionType
        if (LeaderAction){
            LeaderAction(LeaderActionType);
        }
        // Gestione del cambiamento di CurrentPlayer e OtherPlayers

        return true;

    }







    public void endGame(){
        System.out.println("Il vincitore è" + game.GetWinner().getNickname());
    }
    public void GetResourcesFromRow(int row,MarketTray marketTray) {
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
                CurrentPlayer.getFaithTrack().setRedPosition(1);
            } else if (newresource.getColorMarble() == MarketMarble.ColorMarble.WHITE) {
                if (CurrentPlayer.getLeaderCard(0) instanceof LeaderCard1 && CurrentPlayer.getLeaderCard(0).isActivate()) {
                    if (CurrentPlayer.getLeaderCard(1) instanceof LeaderCard1 && CurrentPlayer.getLeaderCard(1).isActivate()) {
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
                } else if (CurrentPlayer.getLeaderCard(1) instanceof LeaderCard1 && CurrentPlayer.getLeaderCard(1).isActivate()) {
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
            for (Player otherplayer : OtherPlayers){
                otherplayer.getFaithTrack().setRedPosition(1);
            }
        }
        else{
            if(!(CurrentPlayer.getWarehouse().addToRow(coloredMarble, row))){
                for (Player otherplayer : OtherPlayers){
                    otherplayer.getFaithTrack().setRedPosition(1);
                }
            }
        }

    }
    public boolean acquireCard( int cellRowNumber, int cellColNumber, int slot) {
        ArrayList<CostOfCard> cost = game.getDevelopmentGrid().getSingleCell(cellRowNumber, cellColNumber).getTopCard().getCost();
        if (!(CurrentPlayer.CheckResourcesForAcquisition(cost))) {
            return false;
        }
        if (!CurrentPlayer.getSlotsBoard().getSlots().get(slot - 1).CanBeAddedInTheSlot(game.getDevelopmentGrid().get(cellRowNumber, cellColNumber))) {
            return false;
        }
        return true;
    }
    public boolean moveResourceFromWarehouse(int WarehouseRow1, int Warehouse2) {
        return CurrentPlayer.getWarehouse().MoveResource(WarehouseRow1, Warehouse2);
    }
    public void LeaderAction(int LeaderActionType){
        int LeaderCard = 0;
        switch (LeaderActionType){
            case 0: // attivare solo una carta Leader
                //Che carta Leader vuoi attivare? setta Leader Card
                if (CurrentPlayer.getLeaderCard(LeaderCard).canBeActivated(CurrentPlayer)){
                    CurrentPlayer.getLeaderCard(LeaderCard).setActivate(true);
                    CurrentPlayer.getLeaderCard(LeaderCard).effect(CurrentPlayer);
                }
            case 1: // Scartare solo una carta Leader
                //Che carta Leader vuoi scartare? setta Leader Card
                if (CurrentPlayer.getLeaderCard(LeaderCard).isActivate()){
                    System.out.println("Non puoi scartare questa carta Leader perchè è stata giocata");
                }
                else {
                    CurrentPlayer.DiscardLeaderCard(LeaderCard);
                    for (Player otherplayer : OtherPlayers){
                        otherplayer.getFaithTrack().setRedPosition(1);
                    }
                }
            case 2: // attivare solo una carta Leader e scartarne una
                //Che carta Leader vuoi attivare? setta Leader Card
                if (CurrentPlayer.getLeaderCard(LeaderCard).canBeActivated(CurrentPlayer)){
                    CurrentPlayer.getLeaderCard(LeaderCard).setActivate(true);
                    CurrentPlayer.getLeaderCard(LeaderCard).effect(CurrentPlayer);
                }
                //Che carta Leader vuoi scartare? setta Leader Card
                if (CurrentPlayer.getLeaderCard(LeaderCard).isActivate()){
                    System.out.println("Non puoi scartare questa carta Leader perchè è stata giocata");
                }
                else {
                    CurrentPlayer.DiscardLeaderCard(LeaderCard);
                    for (Player otherplayer : OtherPlayers){
                        otherplayer.getFaithTrack().setRedPosition(1);
                    }
                }
            case 3: //attivare due carte Leader

                if (CurrentPlayer.getLeaderCard(0).canBeActivated(CurrentPlayer)){
                    CurrentPlayer.getLeaderCard(0).setActivate(true);
                    CurrentPlayer.getLeaderCard(0).effect(CurrentPlayer);
                }
                if (CurrentPlayer.getLeaderCard(1).canBeActivated(CurrentPlayer)){
                    CurrentPlayer.getLeaderCard(1).setActivate(true);
                    CurrentPlayer.getLeaderCard(1).effect(CurrentPlayer);
                }
            case 4: // scartare due carte Leader
                if (CurrentPlayer.getLeaderCard(0).isActivate()){
                    System.out.println("Non puoi scartare la prima carta Leader perchè è stata giocata");
                }
                else {
                    CurrentPlayer.DiscardLeaderCard(0);
                    for (Player otherplayer : OtherPlayers){
                        otherplayer.getFaithTrack().setRedPosition(1);
                    }
                }
                if (CurrentPlayer.getLeaderCard(1).isActivate()){
                    System.out.println("Non puoi scartare la seconda carta Leader perchè è stata giocata");
                }
                else {
                    CurrentPlayer.DiscardLeaderCard(1);
                    for (Player otherplayer : OtherPlayers){
                        otherplayer.getFaithTrack().setRedPosition(1);
                    }
                }

        }
    }


     */

/*
    @Override
    public void update(VirtualView message, int code) {

    }


    @Override
    public void updateTest(SocketMessage message) throws IOException {

    }


    /*public void setA(int a) throws IOException {
        game.setA(a);
    }*/


}

 */





//metodo TURNO SUCCESSIVO

//metodo FINISCI PARTITA
//metodo conta punti

