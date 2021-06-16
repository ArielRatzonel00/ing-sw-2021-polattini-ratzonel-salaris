package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.CostOfCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Messages.*;

import java.util.ArrayList;
import java.util.Scanner;

public interface UserInterface {
    void Waiting(Scanner scanner);
    void askOnline(Scanner scanner);
    void askMultiplayer(Scanner scanner);
    void askNickname(Scanner scanner);
    void askNumberOfPlayers(Scanner scanner);
    void FourLeaderCards(Scanner scanner);
    void DiscardInitialLeaderCards(Scanner scanner, ArrayList<LeaderCard> leaderCards, DiscardInitialLeaderCardsMessage discardInitialLeaderCardsMessage);
    void InitialResources(Scanner scanner, int PlayerIndex, InitialResourcesMessage initialResourcesMessage);
    int Menù(Scanner scanner, boolean actionDone, int leaderCardActionAvailable, boolean isSinglePlayer);
    void DealWithResourcesFromMarketTray(Scanner scanner, MarketTrayActionResponse marketTrayActionResponse, DealWithResourcesFromMarketTrayMessage dealWithResourcesFromMarketTrayMessage, int id);
    void PopeFavorStateEventOccured(Scanner scanner);
    void DealWithResFromMarkTrayResponse(Scanner scanner, DealWithResourcesFromMarketTrayResponse dealWithResourcesFromMarketTrayResponse, boolean isSinglePlayer);
    void WantToBuyCardResponse(Scanner scanner, WantToBuyCardResponse wantToBuyCardResponse, int ID);
    void PrintMessages(String string);
    void Payment(Scanner scanner, ArrayList<CostOfCard> cost, ArrayList<CostOfCard> resourcesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse, ArrayList<Integer> rows, int playerIndex);
    void WantToActivateProdResponse(Scanner scanner, int PlayerIndex);
    void Produce(Scanner scanner, WantActivateProductionResponse wantActivateProductionResponse, ProduceMessage produceMessage, int PlayerIndex, int prod);
    int ActionMenu(Scanner scanner);
    void BuyCardChoice(Scanner scanner, WantToBuyCardMessage wantToBuyCardMessage, int ID);
    int ProduceChoice(Scanner scanner,int ID,WantActivateProductionMessage wantActivateProductionMessage);
    void MarketTrayActionChoice(Scanner scanner, MarketTrayActionMessage marketTrayActionMessage);
    void SeePersonalBoardChoice(Scanner scanner, int ID, boolean isSinglePlayer);
    void MoveResourcesChoice(Scanner scanner, int ID, MoveResourcesMessage moveResourcesMessage);
    int LeaderCardActionChoice(Scanner scanner, int ID);
    int ActivateLeaderCardActionChoice(Scanner scanner);
    int DiscardLeaderCardActionChoice(Scanner scanner);
    void GameStarted(Scanner scanner);
    void GeneralInformationchoice(Scanner scanner);
    void newWarehosue(Scanner scanner, int ID);
    void waitingForOtherPlayers(Scanner scanner);
    void singlePlayerGameFinished(boolean redWon, int TotalPoints);
    void handleDisconnection();
    //void ShowCard(LeaderCard leaderCard);
}
