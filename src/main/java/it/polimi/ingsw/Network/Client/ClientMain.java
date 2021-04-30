package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Controller.SinglePlayerManager;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerFaithTrack;
import it.polimi.ingsw.Model.SinglePlayerGame;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args){
        String nickname;
        Scanner stdin = new Scanner(System.in);                  //Usato per ricevere da tastiera

        System.out.println("Nickname:");
        nickname = stdin.nextLine();

        System.out.println("Welcome " + nickname + ", Multiplayer (m) o Singleplayer (s) ?");

        //SinglePlayerGame, doesn't connect to Server;
        if (stdin.nextLine().equalsIgnoreCase("s")) {
            SinglePlayerManager singlePlayerManager=new SinglePlayerManager(nickname);
            System.out.println("Let's start the game!");
        }
        else{
            if((args.length>0 && args[0].equalsIgnoreCase("CLI")) || true){ // ||True l'ho messo ora solo perchè almeno per
                                                                                    //ora parte sempre con la CLI
                Client client = new Client("127.0.0.1", 1336);
                try{
                    System.out.println("Crezione game...");
                    client.startClient();
                }catch (IOException e){
                    System.err.println(e.getMessage());
                }
            }
            else{
                //Application.launch(Gui.class);
            }
        }
    }
}