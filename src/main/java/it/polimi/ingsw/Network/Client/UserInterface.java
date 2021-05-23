package it.polimi.ingsw.Network.Client;

import java.util.Scanner;

public interface UserInterface {
    void askOnline(Scanner scanner);
    void askMultiplayer(Scanner scanner);
    void askNickname(Scanner scanner);
    void askNumberOfPlayers(Scanner scanner);
}
