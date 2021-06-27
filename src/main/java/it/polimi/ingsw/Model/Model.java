package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Markers.Marker;
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
    private boolean lastTurn = false;
    private boolean lastTurnSinglePlayer = false;
    private boolean redWonSP = false;
    private boolean CheckedPopeFavorState1 = false;
    private boolean CheckedPopeFavorState2 = false;
    private boolean CheckedPopeFavorState3 = false;
    private boolean disconnection = false;
    public Model(ArrayList<Player> players) {
        this.developmentGrid = new DevelopmentGrid(deck);
        this.marketTray = new MarketTray();
        this.players = players;
        if (players.size() == 1){
            this.IsSinglePlayerGame = true;
        }
    }

    public boolean isDisconnection() {
        return disconnection;
    }

    public void setDisconnection(boolean disconnection) {
        notifyDisconnection();
        this.disconnection = disconnection;
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


    /**
     * Assigns the initial four leader cards
     * @param PlayerIndex index of the player that will receive the initial four leader cards
     */

    public void AssignFourLeaderCards(int PlayerIndex){
        Player currentplayer = players.get(PlayerIndex);
        System.out.println("Asssegna 4leader nel game");
        currentplayer.AssignFourLeaderCard(deck.getTopFourLeaderCard());
        System.out.println(currentplayer.getLeaderCards().size());
        notifyFourLeaderCards(PlayerIndex, currentplayer.getLeaderCards(), developmentGrid.getTopcards(), marketTray, currentplayer.getNickname(), IsSinglePlayerGame, markers) ;

    }

    /**
     * Discards two of the four initial leadear cards
     * @param PlayerIndex index of the player in the game
     * @param LeaderCard1Index index of the first leader card to discard
     * @param LeaderCard2Index index of the second leader card to discard
     */
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

    /**
     * Method that shift the market tray and notifies to the client the marbles that he collected
     * @param PlayerIndex index of the player in the game
     * @param isRow distinguishes between row and col
     * @param index index of the row/col of the market tray
     */
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

    /**
     * Method that modifies the model with the choices done by the player with the marbles after a market tray action
     * @param PlayerIndex index of the player in the game
     * @param keepResource choices of the player (for every resources he choice if keep it or leave it)
     * @param marbles color of the marbles with which the player interacts
     * @param rowsOfWarehouse if the player choose to keep a marble, he also choose the row of the warehouse to place it, this param keep the choices
     */
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
        ArrayList<PopeFavorState> popeFavorStates = new ArrayList<>();
        Player currentPlayer = players.get(PlayerIndex);
        for (Boolean k : keepResource) {
            if (marbles.get(contIndexMarblesRows) == MarketMarble.ColorMarble.RED) {
                CurrPlayerAdvances++;
                returnedValue = currentPlayer.getFaithTrack().setRedPosition(1);
                if (returnedValue == 3){
                    if (IsSinglePlayerGame){
                        lastTurnSinglePlayer = true;
                        redWonSP = true;
                    }
                    else {
                        lastTurn = true;
                    }
                }
                PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                if (PopeFavorStateChanged != 0) {
                    PopeFavorStateEvent = true;
                    popeFavorStates = getPopeFavorStates();
                }
            } else {
                if (!k || !currentPlayer.getWarehouse().addToRow(new MarketMarble(marbles.get(contIndexMarblesRows)), rowsOfWarehouse.get(contIndexMarblesRows))) {
                    if (!IsSinglePlayerGame) {
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
                                    lastTurn = true;
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
                    } else {
                        OtherPlayerAdvances++;
                        returnedValue = players.get(0).getFaithTrack().setBlackPosition(1);
                        PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                        if (PopeFavorStateChanged!=0){
                         PopeFavorStateEvent = true;
                         popeFavorStates = getPopeFavorStates();
                        }
                        if (returnedValue == 3){
                            lastTurnSinglePlayer = true;
                            redWonSP = false;
                        }
                    }
                }
            }
            contIndexMarblesRows++;
        }
        notifyDealWithResourceFromMarketTrayresponse(PlayerIndex, currentPlayer.getWarehouse(), CurrPlayerAdvances, OtherPlayerAdvances, PopeFavorStateEvent, popeFavorStates);

    }

    /**
     * Checks if the card selected can be purchased and can be added in the slot selected
     * @param PlayerIndex index of the player in the game
     * @param row row of the position in the devGrid of the card selected
     * @param col col of the position in the devGrid of the card selected
     * @param slot slot to place the card selected
     */
    public void WantToBuyCard(int PlayerIndex, int row, int col, int slot){
        String phrasetoShow = "";
        ArrayList<CostOfCard> cost = new ArrayList<>();

        if (developmentGrid.getSingleCell(row,col)!= null && row>=0 && row <=2 && col>=0 && col <= 3 && developmentGrid.getSingleCell(row,col).getTopCard()!= null){
            cost = developmentGrid.getSingleCell(row, col).getTopCard().getCost();
            applyDiscount(PlayerIndex,cost);
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
        notifyWantToBuyCardResponse(PlayerIndex, phrasetoShow,row, col, slot, cost);

    }

    /**
     * Places the card in the slot, update the productions available and removes the resources with which the player payed
     * @param PlayerIndex index of the player in the game
     * @param resourcesFromStrongbox resources taken from the strongbox
     * @param resourcesFromWarehouse resources taken from the warehouse
     * @param rows rows of the warehouse
     * @param row row of the position in the devGrid of the card selected
     * @param col col of the position in the devGrid of the card selected
     * @param slot slot to place the card selected
     */
    public void BuyCard(int PlayerIndex, ArrayList<CostOfCard> resourcesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int row, int col, int slot ) {
        int contRow = 0;
        Player currentPlayer = players.get(PlayerIndex);

        contRow = 0;
        for (CostOfCard resourceFromStrongbox2 : resourcesFromStrongbox) {
            currentPlayer.getStrongbox().RemoveResourcesFromStrongbox(resourceFromStrongbox2.getCostNumber(), resourceFromStrongbox2.getCostColor());
        }
        for (CostOfCard resourceFromWarehouse2 : resourcesFromWarehouse) {
            currentPlayer.getWarehouse().getRow(rows.get(contRow)).removeMarble(resourceFromWarehouse2.getCostColor(), resourceFromWarehouse2.getCostNumber());
            contRow++;
        }
        DevelopmentCard card = developmentGrid.remove(row, col);
        if (developmentGrid.getSingleCell(0,col).getTopCard() == null && developmentGrid.getSingleCell(1,col).getTopCard() == null && developmentGrid.getSingleCell(2,col).getTopCard() == null ){
            redWonSP = false;
            lastTurnSinglePlayer = true;
        }
        currentPlayer.buyCard(card,slot);
        currentPlayer.setProductionsAvailable(slot);
        if (currentPlayer.getSlotsBoard().filterCount(1) + currentPlayer.getSlotsBoard().filterCount(2) + currentPlayer.getSlotsBoard().filterCount(3) == 7){
            if (IsSinglePlayerGame){
                lastTurnSinglePlayer = true;
                redWonSP = true;
            }
            else {
                lastTurn = true;
            }
        }
        notifyCardBuyedResponse(PlayerIndex, developmentGrid.getTopcards(), currentPlayer.getWarehouse(), currentPlayer.getStrongbox(), card,currentPlayer.getProductionsAvailable(), slot);
    }

    /**
     * Removes the leader card selected and make the player advance by one in the faithTrack
     * @param PlayerIndex index of the player in the game
     * @param NCard index of the card to discard
     */
    public void DiscardLeaderCardAction(int PlayerIndex, int NCard) {
        int returnedvalue = 0;
        int PopeFavorStateChanged = 0;
        boolean popeFavorEvent = false;
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCards().size() > NCard && !currentplayer.getLeaderCard(NCard).isActivate() ){
            currentplayer.DiscardLeaderCard(NCard);
                returnedvalue = currentplayer.getFaithTrack().setRedPosition(1);
                if (returnedvalue == 3){
                    if (IsSinglePlayerGame){
                        lastTurnSinglePlayer = true;
                        redWonSP = true;
                    }
                    else {
                        lastTurn = true;
                    }
                }
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
            notifyDiscardLeaderCardActionResponse(PlayerIndex,NCard,false, false, null);
        }
    }

    /**
     * Activates the leader card selected by applying the effect of the leader card
     * @param PlayerIndex index of the player in the game
     * @param NCard index of the card to activate
     */
    public void ActivateLeaderCardAction(int PlayerIndex, int NCard){
        Player currentplayer = players.get(PlayerIndex);
        if (currentplayer.getLeaderCard(NCard) != null && !currentplayer.getLeaderCard(NCard).isActivate()){
            if (currentplayer.getLeaderCard(NCard).canBeActivated(currentplayer)){
                currentplayer.getLeaderCard(NCard).setActivate(true);
                currentplayer.getLeaderCard(NCard).effect(currentplayer);
                notifyActivateLeaderCardActionResponse(PlayerIndex,NCard,true, currentplayer.getWarehouse().getRows(),currentplayer.getProductionsAvailable());
            }
            else {
                notifyActivateLeaderCardActionResponse(PlayerIndex,NCard,false, null, null);
            }
        }

    }


    /**
     * Move the resources from row1 to row2 and the other way around
     * @param PlayerIndex index of the player in the game
     * @param row1 index of the row
     * @param row2 index of the row
     */
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
                            resources[0]+=productionBasicCost.get(0).getCostNumber();
                            break;
                        case GREY:
                            resources[1]+=productionBasicCost.get(0).getCostNumber();
                            break;
                        case PURPLE:
                            resources[2]+=productionBasicCost.get(0).getCostNumber();
                            break;
                        case YELLOW:
                            resources[3]+=productionBasicCost.get(0).getCostNumber();
                            break;
                    }
                    if (productionBasicCost.size() > 1) {
                        switch (productionBasicCost.get(1).getCostColor()) {
                            case BLUE:
                                resources[0]++;
                                break;
                            case GREY:
                                resources[1]++;
                                break;
                            case PURPLE:
                                resources[2]++;
                                break;
                            case YELLOW:
                                resources[3]++;
                                break;
                        }
                    }
                }
                else{
                    for (CostOfCard c: currentplayer.getProductionsAvailable().get(index).getProductionCost()){
                        switch (c.getCostColor()){
                            case BLUE:
                                resources[0]+= c.getCostNumber();
                                break;
                            case GREY:
                                resources[1]+= c.getCostNumber();
                                break;
                            case PURPLE:
                                resources[2]+= c.getCostNumber();
                                break;
                            case YELLOW:
                                resources[3]+= c.getCostNumber();
                                break;
                        }
                    }
                }
            }
            if(currentplayer.CheckResourcesForProduce(resources)){
                ok = true;
            }
            notifyWantActivateProductionResponse(PlayerIndex, productionBasicCost, productionsIndexes, ok);

        }

    /**
     * Activates the productions selected adding the profit and removing the cost
     * @param PlayerIndex index of the player in the game
     * @param production indexes of the production to activate
     * @param ResourcesFromStrongbox resources from strongbox to remove
     * @param ResourcesFromWarehouse resources from warehouse to remove
     * @param rows rows of the resources from warehouse to remove
     * @param profit if the production contains a profit that can be chosen, this param contains the color of the chosen resource
     */
    public void Produce(int PlayerIndex, ArrayList<Integer> production, ArrayList<ArrayList<CostOfCard>> ResourcesFromStrongbox, ArrayList<ArrayList<CostOfCard>> ResourcesFromWarehouse, ArrayList<ArrayList<Integer>> rows, ArrayList<MarketMarble.ColorMarble> profit) {
        int returnedValue = 0;
        Player currentplayer = players.get(PlayerIndex);
        int indexRow = 0;
        int indexProfit = 0;
        int PopeFavorStateChanged = 0;
        int redPositions = 0;
        for (int i = 0; i < production.size(); i++) {
            indexRow = 0;
            for (CostOfCard c : ResourcesFromStrongbox.get(i)) {
                currentplayer.getStrongbox().RemoveResourcesFromStrongbox(c.getCostNumber(), c.getCostColor());
            }
            for (CostOfCard c : ResourcesFromWarehouse.get(i)) {
                currentplayer.getWarehouse().getRow(rows.get(i).get(indexRow)).removeMarble(c.getCostColor(), c.getCostNumber());
                indexRow++;
            }
            if (production.get(i) != 0 && production.get(i) != 4 && production.get(i) != 5) {
                for (CostOfCard c : currentplayer.getProductionsAvailable().get(production.get(i)).getProductionProfit()) {
                    if (c.getCostColor() == MarketMarble.ColorMarble.RED) {
                        for (int r = 0; r < c.getCostNumber(); r++) {
                            returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                            if (returnedValue == 3){
                                if (IsSinglePlayerGame){
                                    lastTurnSinglePlayer = true;
                                    redWonSP = true;
                                }
                                else {
                                    lastTurn = true;
                                }
                            }
                            PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                            redPositions += 1;
                        }
                    } else {
                        currentplayer.getStrongbox().AddResource(c.getCostNumber(), c.getCostColor());
                    }
                }
            } else {
                if (profit.get(indexProfit) == MarketMarble.ColorMarble.RED) {
                    returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                    if (returnedValue == 3){
                        if (IsSinglePlayerGame){
                            lastTurnSinglePlayer = true;
                            redWonSP = true;
                        }
                        else {
                            lastTurn = true;
                        }
                    }
                    PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                    redPositions += 1;
                } else {
                    currentplayer.getStrongbox().AddResource(1, profit.get(indexProfit));

                }
                if (production.get(i) != 0) {
                    returnedValue = currentplayer.getFaithTrack().setRedPosition(1);
                    if (returnedValue == 3){
                        if (IsSinglePlayerGame){
                            lastTurnSinglePlayer = true;
                            redWonSP = false;
                        }
                        else {
                            lastTurn = true;
                        }
                    }
                    PopeFavorStateChanged += CheckPopeFavorStateActivatedByCurrentPlayer(returnedValue);
                    redPositions += 1;
                }
                indexProfit++;
            }
        }

        if (PopeFavorStateChanged > 0){
            notifyProductionResponse(PlayerIndex, currentplayer.getWarehouse().getRows(),currentplayer.getStrongbox().allResources(),redPositions,true,getPopeFavorStates());
        }
        else {
            notifyProductionResponse(PlayerIndex, currentplayer.getWarehouse().getRows(),currentplayer.getStrongbox().allResources(),redPositions,false,null);
        }
    }

    /**
     * Ends the turn of a player and notifies the beginning of a new turn, if the game is finished, notifies the end of the game and the winner
     * @param PlayerIndex index of the player in the game
     */
    public void EndTurn(int PlayerIndex) {
        int IndexNewTurn = 0;
        if (!IsSinglePlayerGame) {
            if (lastTurn && PlayerIndex == players.size() - 1) {
                Player winnerPlayer = GetWinnerMultiplayer();
                notifyFinishMultiplayerGame(winnerPlayer.getNickname());
            } else {
                players.get(PlayerIndex).setYourTurn(false);
                if (PlayerIndex != players.size() - 1) {
                    players.get(PlayerIndex + 1).setYourTurn(true);
                    IndexNewTurn = PlayerIndex + 1;
                } else {
                    IndexNewTurn = 0;
                    players.get(0).setYourTurn(true);
                }
                notifyNewTurn(IndexNewTurn, 0, false, null, null, null);
            }
        }
        else {
            if (lastTurnSinglePlayer){
                int totPoints = 0;
                if (redWonSP){
                    totPoints = players.get(0).GetTotalPoints();
                }
                notifyFinishSingleplayerGame(redWonSP, totPoints);
            }
            else {
                int blackPositions = 0;
                int returnedvalue = 0;
                int PopeFavorStateChanged = 0;
                Marker topMarker = markers.getTopMarker();
                blackPositions = topMarker.MarkerEffect(this);
                if (blackPositions == 1) {
                    returnedvalue = players.get(0).getFaithTrack().setBlackPosition(1);
                } else if (blackPositions == 2) {
                    returnedvalue = players.get(0).getFaithTrack().setBlackPosition(1);
                    returnedvalue += players.get(0).getFaithTrack().setBlackPosition(1);
                }
                PopeFavorStateChanged = CheckPopeFavorStateActivatedByCurrentPlayer(returnedvalue);
                if (PopeFavorStateChanged != 0) {
                    notifyNewTurn(PlayerIndex, blackPositions, true, getPopeFavorStates(), markers.getMarkers().get(markers.getMarkers().size() - 1), developmentGrid.getTopcards());
                } else {
                    notifyNewTurn(PlayerIndex, blackPositions, false, null, markers.getMarkers().get(markers.getMarkers().size() - 1), developmentGrid.getTopcards());
                }
            }

        }
    }

    public MarkerStack getMarkers() {
        return markers;
    }

    /**
     * @return the Player that has won the game
     */
    public Player GetWinnerMultiplayer() {
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

    /**
     * Set the variable start at true if the game has reached the number of players expected
     */
    public void incrementContForStart() {
        this.contForStart ++;
        if(contForStart==players.size())
            start=true;
    }

    /**
     * When a pope favor state happens, check the positions of the player and based on that activate/discards the pope favor state of the player
     * @param PopeFavorState pope favor state number
     */
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
                return 2;
            }
            else {
                CheckedPopeFavorState3 = true;
                return 3;
            }
        }
        return 0;
    }

    public void applyDiscount(int playerIndex, ArrayList<CostOfCard> cost){
        Player player = players.get(playerIndex);
        for (CostOfCard c : cost){
            switch (c.getCostColor()){
                case PURPLE -> c.setCostNumber(c.getCostNumber() - player.getDiscountPurple());
                case BLUE -> c.setCostNumber(c.getCostNumber() - player.getDiscountBlue());
                case GREY -> c.setCostNumber(c.getCostNumber() - player.getDiscountGrey());
                case YELLOW -> c.setCostNumber(c.getCostNumber() - player.getDiscountYellow());
            }
        }
    }
}

