package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Observer.ModelObservable;

import java.util.ArrayList;

public class Model extends ModelObservable {

    // Class that represents the Model

    private ArrayList<Player> players;
    private MarketTray marketTray;
    private DevelopmentGrid developmentGrid;
    private MarkerStack markers = new MarkerStack();
    private Deck deck = new Deck();
    private boolean IsSinglePlayerGame = false;
    private boolean start;
    private int contForStart;
    private Player CurrentPlayer;
    private int a;
    private boolean CheckedPopeFavorState1 = false;
    private boolean CheckedPopeFavorState2 = false;
    private boolean CheckedPopeFavorState3 = false;
    public Model(ArrayList<Player> players) {
        this.developmentGrid = new DevelopmentGrid(deck);
        this.marketTray = new MarketTray();
        this.players = players;
        if (players.size() == 1){
            this.IsSinglePlayerGame = true;
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public MarketTray getMarketTray() {
        return marketTray;
    }

    public DevelopmentGrid getDevelopmentGrid() {
        return developmentGrid;
    }

    public int getNumberOfPlayers() {
        if (players!=null)
        return players.size();
        else
            return 0;
    } // numero di giocatori


    public void AssignFourLeaderCards(int PlayerIndex){
        Player currentplayer = players.get(PlayerIndex);
        System.out.println("Asssegna 4leader nel game");
        currentplayer.AssignFourLeaderCard(deck.getTopFourLeaderCard());
        System.out.println(currentplayer.getLeaderCards().size());
        notifyFourLeaderCards(PlayerIndex, currentplayer.getLeaderCards(), developmentGrid.getTopcards(), marketTray, currentplayer.getNickname());

    }

    public void DiscardInitialLeaderCards(int PlayerIndex, int LeaderCard1Index, int LeaderCard2Index){
        Player currentplayer = players.get(PlayerIndex);
        currentplayer.DiscardLeaderCard(LeaderCard1Index);
        currentplayer.DiscardLeaderCard(LeaderCard2Index);
        notifyLeaderCardsAfterFirstDiscard(PlayerIndex,currentplayer.getLeaderCards(),currentplayer.getProductionsAvailable());
    }
    public void SetInitialResourcesForFirstPlayer() {
        Player currentplayer = players.get(0);
        incrementContForStart();
        notifyInitialResourcesSet(0, start, currentplayer.getWarehouse(),0);
    }
    public void SetInitialResourcesForSecondPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        Player currentplayer = players.get(1);
        currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble), row);
        incrementContForStart();
        notifyInitialResourcesSet(1, start, currentplayer.getWarehouse(),0);
    }
    public void SetInitialResourcesForThirdPlayer(MarketMarble.ColorMarble colorMarble, int row) {
        Player currentplayer = players.get(2);
        currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble), row);
        currentplayer.getFaithTrack().setRedPosition(1);
        incrementContForStart();
        notifyInitialResourcesSet(2, start, currentplayer.getWarehouse(), 1);
    }
    public void SetInitialResourcesForForthPlayer(MarketMarble.ColorMarble colorMarble1, int row1,MarketMarble.ColorMarble colorMarble2, int row2 ) {
        Player currentplayer = players.get(3);
        incrementContForStart();
        if (row1 == row2 && (!colorMarble1.equals(colorMarble2) || row1 == 0)){
            //NotifyErrorMessage
        }
        else if (row1 != row2 && colorMarble1.equals(colorMarble2)){
            //NotifyErrorMessage
        }
        else {
            currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble1), row1);
            currentplayer.getWarehouse().addToRow(new MarketMarble(colorMarble2), row2);
            currentplayer.getFaithTrack().setRedPosition(1);
            notifyInitialResourcesSet(3, start, currentplayer.getWarehouse(),1);
        }
    }
    public void MarketTrayAction(int PlayerIndex, boolean isRow, int index){
        Player currentplayer = players.get(PlayerIndex);

        ArrayList<MarketMarble> returnedMarbles = new ArrayList<>();
        if (isRow) {
                returnedMarbles = marketTray.ShiftMatrixByRow(index);
        } else {
                returnedMarbles = marketTray.ShiftMatrixByCol(index);
        }
        notifyMarketTrayActionResponse(PlayerIndex,marketTray.getMarketMatrix(),marketTray.getOustideMarble(),returnedMarbles, currentplayer.getChangeWhite1(),currentplayer.getChangeWhite2());
    }
    public void DealWithResources(int PlayerIndex,  ArrayList<Boolean> keepResource, ArrayList<MarketMarble.ColorMarble> marbles, ArrayList<Integer> rowsOfWarehouse) {
        boolean NeedToCheckPopeFavorState1 = false;
        boolean NeedToCheckPopeFavorState2 = false;
        boolean NeedToCheckPopeFavorState3 = false;
        int contIndexMarblesRows = 0;
        boolean PopeFavorStateEvent = false;
        int CurrPlayerAdvances = 0;
        int OtherPlayerAdvances = 0;
        int returnedValue = 0;
        int PopeFavorStateChanged = 0;
        ArrayList<PopeFavorState> popeFavorStates = null;
        Player currentPlayer = players.get(PlayerIndex);
        for (Boolean k : keepResource) {
            if (marbles.get(contIndexMarblesRows) == MarketMarble.ColorMarble.RED) {
                CurrPlayerAdvances++;
                returnedValue = currentPlayer.getFaithTrack().setRedPosition(1);
                PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                if (PopeFavorStateChanged != 0) {
                    PopeFavorStateEvent = true;
                    popeFavorStates = getPopeFavorStates();
                }
            } else {
                if (!k || !currentPlayer.getWarehouse().addToRow(new MarketMarble(marbles.get(contIndexMarblesRows)), rowsOfWarehouse.get(contIndexMarblesRows))) {
                    OtherPlayerAdvances++;
                    for (Player otherplayer : players) {
                        if (!otherplayer.equals(currentPlayer)) {
                            returnedValue = otherplayer.getFaithTrack().setRedPosition(1);
                            if (returnedValue == 1) {
                                NeedToCheckPopeFavorState1 = true;
                            } else if (returnedValue == 2) {
                                NeedToCheckPopeFavorState2 = true;
                            } else if (returnedValue == 3) {
                                NeedToCheckPopeFavorState3 = true;
                            }
                            if (NeedToCheckPopeFavorState1 && !CheckedPopeFavorState1) {
                                CheckPopeFavorState(1);
                                CheckedPopeFavorState1 = true;
                                PopeFavorStateEvent = true;
                                popeFavorStates = getPopeFavorStates();
                            } else if (NeedToCheckPopeFavorState2 && !CheckedPopeFavorState2) {
                                CheckPopeFavorState(2);
                                CheckedPopeFavorState2 = true;
                                PopeFavorStateEvent = true;
                                popeFavorStates = getPopeFavorStates();

                            } else if (NeedToCheckPopeFavorState3 && !CheckedPopeFavorState3) {
                                CheckPopeFavorState(2);
                                CheckedPopeFavorState3 = true;
                                PopeFavorStateEvent = true;
                                popeFavorStates = getPopeFavorStates();
                            }
                        }
                    }
                }
            }
            contIndexMarblesRows++;
        }
        notifyDealWithResourceFromMarketTrayresponse(PlayerIndex, currentPlayer.getWarehouse(), CurrPlayerAdvances, OtherPlayerAdvances, PopeFavorStateEvent, popeFavorStates);
    }

    public void WantToBuyCard(int PlayerIndex, int row, int col, int slot){
        String phrasetoShow = "";
        ArrayList<CostOfCard> cost = new ArrayList<>();
        ArrayList<Boolean> problems = new ArrayList<>();
        if (developmentGrid.getSingleCell(row,col)!= null && row>=0 && row <=2 && col>=0 && col <= 3 && developmentGrid.getSingleCell(row,col).getTopCard()!= null){
            cost = developmentGrid.getSingleCell(row, col).getTopCard().getCost();
            if (slot < 0 || slot > 3 || !players.get(PlayerIndex).getSlotsBoard().getSlots().get(slot).CanBeAddedInTheSlot(developmentGrid.getSingleCell(row,col).getTopCard())){
                phrasetoShow = "The card can't be added in the slot that you selected";
            }
            else {
                if (players.get(PlayerIndex).CheckResourcesForAcquisition(cost)) {
                    phrasetoShow = "You have the resources to add the card and you can add it in the slot that you selected";
                } else {
                    phrasetoShow = "You don't have enough resources to buy this card";
                }
            }
        }
        else{
            phrasetoShow = "The card selected doesn't exist";
            cost = null;
        }
        notifyWantToBuyCardResponse(PlayerIndex, phrasetoShow, slot, cost);
        System.out.println("Arriva nel model");


    }
    public void BuyCard(int PlayerIndex, ArrayList<CostOfCard> resourcesFromStrogbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int row, int col, int slot ) {
        int contRow = 0;
        Player currentPlayer = players.get(PlayerIndex);

        contRow = 0;
        for (CostOfCard resourceFromStrongbox2 : resourcesFromStrogbox) {
            currentPlayer.getStrongbox().RemoveResourcesFromStrongbox(resourceFromStrongbox2.getCostNumber(), resourceFromStrongbox2.getCostColor());
        }
        for (CostOfCard resourceFromWarehouse2 : resourcesFromWarehouse) {
            currentPlayer.getWarehouse().getRow(contRow).removeMarble(resourceFromWarehouse2.getCostColor(), resourceFromWarehouse2.getCostNumber());
            contRow++;
        }
        DevelopmentCard card = developmentGrid.remove(row, col);
        currentPlayer.buyCard(card,slot);

        notifyCardBuyedResponse(PlayerIndex, developmentGrid.getTopcards(), currentPlayer.getWarehouse(), currentPlayer.getStrongbox(), card,currentPlayer.getProductionsAvailable(), slot);
    }

    public void DiscardLeaderCardAction(int PlayerIndex, int NCard) {
        int returnedvalue = 0;
        int PopeFavorStateChanged = 0;
        boolean popeFavorEvent = false;
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCards().size() > NCard && !currentplayer.getLeaderCard(NCard).isActivate() ){
            currentplayer.DiscardLeaderCard(NCard);
            if (!IsSinglePlayerGame) {
                returnedvalue = currentplayer.getFaithTrack().setRedPosition(1);
                PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedvalue);
                if (PopeFavorStateChanged != 0) {
                    popeFavorEvent = true;
                }
                if (popeFavorEvent){
                    notifyDiscardLeaderCardActionResponse(PlayerIndex,NCard,true, true, getPopeFavorStates());
                }
                else {
                    notifyDiscardLeaderCardActionResponse(PlayerIndex,NCard,false, true, null);
                }
            }
            else {
                returnedvalue = players.get(0).getFaithTrack().setBlackPosition(1);
                PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedvalue);
                if (PopeFavorStateChanged!=0){
                    //NotifyFaithTrackChanged And PopeFavorState, Black Advance by one
                }
            }
        }
        else{
            notifyDiscardLeaderCardActionResponse(PlayerIndex,NCard,false, false, null);
        }
    }

    public void ActivateLeaderCardAction(int PlayerIndex, int NCard){
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCard(NCard) != null && !currentplayer.getLeaderCard(NCard).isActivate()){
            if (currentplayer.getLeaderCard(NCard).canBeActivated(currentplayer)){
                currentplayer.getLeaderCard(NCard).setActivate(true);
                currentplayer.getLeaderCard(NCard).effect(currentplayer);
                notifyActivateLeaderCardActionResponse(PlayerIndex,NCard,true);
            }
            else {
                notifyActivateLeaderCardActionResponse(PlayerIndex,NCard,false);
            }
        }

    }


    public void MoveResources(int PlayerIndex, int row1, int row2) {
        Player currentplayer = players.get(PlayerIndex);
        boolean ok = false;
        if (currentplayer.getWarehouse().MoveResource(row1, row2)) {
            ok = true;
        }
        notifyMoveResourcesResponse(PlayerIndex,ok,currentplayer.getWarehouse());
    }
    public void CanProduce(int PlayerIndex, ArrayList<Integer> productionsIndexes, ArrayList<CostOfCard> productionBasicCost){
        Player currentplayer = players.get(PlayerIndex);
        boolean ok = false;

        int[] resources = new int[4]; // 0 Blue, 1 Grey, 2 Purple, 3 Yellow
        resources[0] = 0;
        resources[1] = 0;
        resources[2] = 0;
        resources[3] = 0;

            for (int index : productionsIndexes){
                if (index == 0) {
                    switch (productionBasicCost.get(0).getCostColor()) {
                        case BLUE:
                            resources[0]++;
                        case GREY:
                            resources[1]++;
                        case PURPLE:
                            resources[2]++;
                        case YELLOW:
                            resources[3]++;
                    }
                    switch (productionBasicCost.get(1).getCostColor()) {
                        case BLUE:
                            resources[0]++;
                        case GREY:
                            resources[1]++;
                        case PURPLE:
                            resources[2]++;
                        case YELLOW:
                            resources[3]++;
                    }
                }
                else{
                    for (CostOfCard c: currentplayer.getProductionsAvailable().get(index).getProductionCost()){
                        switch (c.getCostColor()){
                            case BLUE:
                                resources[0]+= c.getCostNumber();
                            case GREY:
                                resources[1]+= c.getCostNumber();
                            case PURPLE:
                                resources[2]+= c.getCostNumber();
                            case YELLOW:
                                resources[3]+= c.getCostNumber();
                        }
                    }
                }
            }
            if(currentplayer.CheckResourcesForProduce(resources)){
                ok = true;
            }
            notifyWantActivateProductionResponse(PlayerIndex, productionsIndexes, ok);

        }

    public void Produce(int PlayerIndex, ArrayList<Integer> production, ArrayList<ArrayList<CostOfCard>> ResourcesFromStrongbox, ArrayList<ArrayList<CostOfCard>> ResourcesFromWarehouse, ArrayList<ArrayList<Integer>> rows, ArrayList<MarketMarble.ColorMarble> profit) {
        int returnedValue = 0;
        Player currentplayer = players.get(PlayerIndex);
        int contRow = 0;
        int j = 0;
        int PopeFavorStateChanged = 0;
        int redPositions = 0;
        for (int i = 0; i < production.size(); i++) {

            for (CostOfCard c : ResourcesFromStrongbox.get(i)) {
                currentplayer.getStrongbox().RemoveResourcesFromStrongbox(c.getCostNumber(), c.getCostColor());
            }
            for (CostOfCard c : ResourcesFromWarehouse.get(i)) {
                currentplayer.getWarehouse().getRow(production.get(i)).removeMarble(c.getCostColor(), c.getCostNumber());
            }
            if (production.get(i) != 0 && production.get(i) != 4 && production.get(i) != 5) {
                for (CostOfCard c : currentplayer.getProductionsAvailable().get(production.get(i)).getProductionProfit()) {
                    if (c.getCostColor() == MarketMarble.ColorMarble.RED) {
                        for (int r = 0; r < c.getCostNumber(); r++) {
                            returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                            PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                            redPositions += 1;
                        }
                    } else {
                        currentplayer.getStrongbox().AddResource(c.getCostNumber(), c.getCostColor());
                    }
                }
            } else {
                if (profit.get(j) == MarketMarble.ColorMarble.RED) {
                    returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                    PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                    redPositions += 1;
                } else {
                    currentplayer.getStrongbox().AddResource(1, profit.get(j));
                }
                if (production.get(i) != 0) {
                    returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                    PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                    redPositions += 1;
                }
                j++;
            }
        }
        if (PopeFavorStateChanged > 0){
            notifyProductionResponse(PlayerIndex, currentplayer.getWarehouse().getRows(),currentplayer.getStrongbox().allResources(),redPositions,true,getPopeFavorStates());
        }
        else {
            notifyProductionResponse(PlayerIndex, currentplayer.getWarehouse().getRows(),currentplayer.getStrongbox().allResources(),redPositions,false,null);
        }
    }

    public void EndTurn(int PlayerIndex){
        int IndexNewTurn = 0;
        players.get(PlayerIndex).setYourTurn(false);
        if (PlayerIndex!= players.size()-1) {
            players.get(PlayerIndex + 1).setYourTurn(true);
            IndexNewTurn = PlayerIndex + 1;
        }
        else {
            IndexNewTurn = 0;
            players.get(0).setYourTurn(true);
        }
        notifyNewTurn(IndexNewTurn);
    }

    public MarkerStack getMarkers() {
        return markers;
    }

    public void MarkerStackAction(){
        int blackPositions = 0;
        int returnedvalue = 0;
        int PopeFavorStateChanged = 0;
        blackPositions = markers.getTopMarker().MarkerEffect(this);
        if (blackPositions== 1) {
            returnedvalue = players.get(0).getFaithTrack().setBlackPosition(1);
        }else if (blackPositions == 2){
            returnedvalue = players.get(0).getFaithTrack().setBlackPosition(1);
            returnedvalue += players.get(0).getFaithTrack().setBlackPosition(1);
        }
        PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedvalue);
        if (PopeFavorStateChanged!=0){
            //Notifica anche il cambiamento dei PopeFavorState
        }
    }

    public Player GetWinner() {
        int MaxPoints = 0;
        int MaxResources = 0;
        Player winner = null;
        ArrayList<Player> PlayersWithMorePoints = new ArrayList<>();
        for (Player player : players) {
            if (player.GetTotalPoints() > MaxPoints) {
                for (int i = 0; i < PlayersWithMorePoints.size(); i++) {
                    PlayersWithMorePoints.remove(PlayersWithMorePoints.size() - 1);
                }
                PlayersWithMorePoints.add(player);
            } else if (player.GetTotalPoints() == MaxPoints) {
                PlayersWithMorePoints.add(player);
            }
        }
        for (Player player : PlayersWithMorePoints) {
            if (player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResourcesInStrongbox() > MaxResources) {
                winner = player;
                MaxResources = player.getWarehouse().getNumberOfTotalResourcesInWarehouse() + player.getStrongbox().getNumberOfTotalResourcesInStrongbox();
            }
        }
        return winner;
    }

    public Deck getDeck() {
        return deck;
    }

    public void incrementContForStart() {
        this.contForStart ++;
        if(contForStart==players.size())
            start=true;
    }
    public void CheckPopeFavorState(int PopeFavorState){
        if (!IsSinglePlayerGame) {
            for (Player p : players) {
                p.CheckPositionPopeFavor(PopeFavorState);
            }
        }
    }
    public ArrayList<PopeFavorState> getPopeFavorStates(){
        ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();
        for (Player p : players){
            popeFavorStates.add(p.getFaithTrack().getPopeFavor1());
            popeFavorStates.add(p.getFaithTrack().getPopeFavor2());
            popeFavorStates.add(p.getFaithTrack().getPopeFavor3());
        }
        return popeFavorStates;

    }
    public int CheckPopeFavorStateActivatedByCurrentPlayer(int PopeFavorState){
        if ((PopeFavorState == 1 && !CheckedPopeFavorState1) || (PopeFavorState == 2 && !CheckedPopeFavorState2) || (PopeFavorState == 3 && !CheckedPopeFavorState3) ){
            if (!IsSinglePlayerGame) {
                for (Player p : players) {
                    p.CheckPositionPopeFavor(PopeFavorState);
                }
            }
            else {
                players.get(0).CheckPositionPopeFavor(PopeFavorState);
            }
            if (PopeFavorState == 1){
                CheckedPopeFavorState1 = true;
                return 1;
            }
            else if (PopeFavorState == 2){
                CheckedPopeFavorState2 = true;
                return 0;
            }
            else {
                CheckedPopeFavorState3 = true;
                return 3;
            }
        }
        return 0;
    }

    /*
    public int GetA() {
        return a;
    }
    public void setA(int a) throws IOException {
        this.a=a;
        List<Integer> interi =new ArrayList<>();
        interi.add(5);
        interi.add(324);
        notifyTest(new Message("abc",interi));
    } */
}





 /*   public void startgame(){
        //Creazione di Development grid
        //Assegnazione di Leader Card a ogni player
        // settaggio di tutte le cose iniziali come creazione di ogni faithTrack/Warehouse ecc per ogni player


    }
    public void finishgame(){
        // Ricordarsi di fare i controlli nelle classi che posso far finire la partita esempio nella classed Faith Track controllare Red Position ecc
        // fai i calcoli per finire la partita



    }

}
  */
