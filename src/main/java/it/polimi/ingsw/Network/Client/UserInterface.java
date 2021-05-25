package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard;
import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;

import java.util.Scanner;

public interface UserInterface {
    void askOnline(Scanner scanner);
    void askMultiplayer(Scanner scanner);
    void askNickname(Scanner scanner);
    void askNumberOfPlayers(Scanner scanner);
    void FourLeaderCards(Scanner scanner);
    void ShowCard(LeaderCard leaderCard);
}
