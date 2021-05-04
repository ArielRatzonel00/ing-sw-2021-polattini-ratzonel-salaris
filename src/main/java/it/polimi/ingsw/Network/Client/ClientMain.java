package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.View.CLI;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        String nickname;
        Scanner stdin = new Scanner(System.in);                  //Usato per ricevere da tastiera

        if((args.length>0 && args[0].equalsIgnoreCase("CLI")) || true){ // ||True l'ho messo ora solo perchè almeno per
                                                                                     //ora parte sempre con la CLI

        CLI view = new CLI();
        view.init();

        /*//SinglePlayerGame, doesn't connect to Server;
        if (stdin.nextLine().equalsIgnoreCase("s")) {
            SinglePlayerManager singlePlayerManager=new SinglePlayerManager(nickname);
            System.out.println("Let's start the game!");
        }

        //Multiplayer Game, needs to connect to the serverSocket!
        else{
                Client client = new Client("127.0.0.1", 1336);
                try{
                    System.out.println("Crezione game...");
                    client.startClient();
                }catch (IOException e){
                    System.err.println(e.getMessage());
                }
            }*/
        }
        else{
            //Application.launch(Gui.class);
        }
    }
}