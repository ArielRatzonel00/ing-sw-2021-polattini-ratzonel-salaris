package it.polimi.ingsw.View;


import it.polimi.ingsw.Model.LeaderCard.*;
import it.polimi.ingsw.Network.Client.UserInterface;
import it.polimi.ingsw.Network.Messages.FourLeaderCardsMessage;
import it.polimi.ingsw.Observer.ViewObservable;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//import it.polimi.ingsw.utils.gameMessage;

public class Cli extends ViewObservable implements UserInterface {
    private boolean SinglePlayer;
    private final PrintStream out;
    String response;

    public Cli() {
        out=System.out;
    }


    @Override
    public void askOnline(Scanner scanner){
    out.println("Would you like to play Online or Offline? (ON/OFF)");
    response=scanner.nextLine();
    Boolean online=false;
    if(response.equalsIgnoreCase("ON"))
        online=true;
    final boolean onlineFinal=online;  //lambda expression require final parameter
        notifyObserver(obs -> {
            try {
                obs.updateOnline(onlineFinal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void askMultiplayer(Scanner scanner){
        out.println("Would you play SinglePlayer or Multiplayer? (S/M)");
        response=scanner.nextLine();
        boolean multiplayer=true;
        if(response.equalsIgnoreCase("S"))
            multiplayer=false;
        final boolean multiplayerFinal=multiplayer;
        notifyObserver(obs-> {
            try {
                obs.updateMultiplayer(multiplayerFinal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void askNickname(Scanner scanner) {
        out.println("Insert your nickname:");
        String name= scanner.nextLine();
        notifyObserver(obs->obs.updateNickname(name));
    }

    @Override
    public void askNumberOfPlayers(Scanner scanner) {
        System.out.println("How many players in the game (2-4)?");
        int numberOfPlayers=scanner.nextInt();
        notifyObserver(obs-> {
            try {
                obs.updateNumberOfPlayers(numberOfPlayers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void  FourLeaderCards(Scanner scanner){
            String s=scanner.nextLine();
            FourLeaderCardsMessage fourLeaderCardsMessage = new FourLeaderCardsMessage();
            notifyObserver(obs-> {
                try {
                    obs.updateMessage(fourLeaderCardsMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }
    @Override
    public void ShowCard(LeaderCard l){
        switch (l.getType()){
            case 1:
                LeaderCard1 l1=(LeaderCard1)l;
                System.out.println("POTERE: Trasforma palline bianche in palline : " + l1.getNewColorMarble() + "\n" +
                    "NECESSITA: 1 devCard colore " + l1.getColorCostOne() + ", 2 devCard colore " + l1.getColorCostTwo() + "\n" +
                    "VICTORY POINTS: " + l1.getVictoryPoints());
            break;
            case 2:
                LeaderCard2 l2=(LeaderCard2)l;
                System.out.println("POTERE: Riduce costo delle DevCard di una risorsa di tipo: " + l2.getDiscount() + "\n" +
                        "NECESSITA: 1 devCard colore " + l2.getFirstcolorCost() + ", 1 devCard colore " + l2.getSecondcolorCost() + "\n" +
                        "VICTORY POINTS: " + l2.getVictoryPoints());
                break;
            case 3:
                LeaderCard3 l3=(LeaderCard3) l;
                System.out.println("POTERE: Aggiunge un extra warehouse (di 2 spazi) di colore " + l3.getColorOfExtraWarehouse() + "\n" +
                        "NECESSITA: 5 risorse di colore " + l3.getColorCost() +  "\n" +
                        "VICTORY POINTS: " + l3.getVictoryPoints());
                break;
            case 4:
                LeaderCard4 l4=(LeaderCard4) l;
                System.out.println( "POTERE: Aggiunge produzione da" + l4.getProduction().getProductionCost().get(0).getCostNumber() + l4.getProduction().getProductionCost().get(0).getCostColor() + " ad un punto fede e una risorsa a tua scelta\n " +
                    "NECESSITA: DevCard di livello 2 di colore" + l4.getCostCardLevelTwo() + "\n" +
                    "VICTORY POINTS: " + l4.getVictoryPoints());
                break;
        }
    }

    public void start() {
        if (SinglePlayer) {
            System.out.println("La partita Single Player è iniziata");
            System.out.println("Scegli due carte tra queste LeaderCard, da scartare");

        }

    }
}























    /*
    private class MessageReceiver implements Observer<String> {

        @Override
        public void update(String message) {
            System.out.println("Received: " + message);
            try{
                String[] inputs = message.split(",");
                handleMove(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            }catch(IllegalArgumentException e){
                clientConnection.asyncSend("Error!");
            }
        }

    }

    private ClientConnection clientConnection;

    public RemoteView(Player player, String opponent, ClientConnection c) {
        super(player);
        this.clientConnection = c;
        c.addObserver(new MessageReceiver());
        c.asyncSend("Your opponent is: " + opponent);

    }

    @Override
    protected void showMessage(Object message) {
        clientConnection.asyncSend(message);
    }

    @Override
    public void update(MoveMessage message)
    {
        showMessage(message.getBoard());
        String resultMsg = "";
        boolean gameOver = message.getBoard().isGameOver(message.getPlayer().getMarker());
        boolean draw = message.getBoard().isFull();
        if (gameOver) {
            if (message.getPlayer() == getPlayer()) {
                resultMsg = gameMessage.winMessage + "\n";
            } else {
                resultMsg = gameMessage.loseMessage + "\n";
            }
        }
        else {
            if (draw) {
                resultMsg = gameMessage.drawMessage + "\n";
            }
        }
        if(message.getPlayer() == getPlayer()){
            resultMsg += gameMessage.waitMessage;
        }
        else{
            resultMsg += gameMessage.moveMessage;
        }

        showMessage(resultMsg);
    }

}

     */

























/* package it.polimi.ingsw.View;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Network.Client.ClientController;
import it.polimi.ingsw.Network.Server.ClientConnection;
import it.polimi.ingsw.Observer.ObservableView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI extends View{
    private ClientConnection clientConnection;
    public CLI(Player player, ArrayList<Player> OtherPlayers, ClientConnection c){
        super(player);
        this.clientConnection = c;
    }

    @Override
    protected void showMessage(String message) {
        clientConnection.asyncSend(message);
    }
    public void update(Mo)


 */
























/*
    ClientController cLientController= new ClientController(this);
    private String nickname;
    private Boolean singleMulti=false; //False represent singlePlayer, True represent Multiplayer
    Scanner stdin = new Scanner(System.in);

    @Override
    public void init() throws IOException {
        System.out.println("\n" +
                "\t \uD835\uDD44\uD835\uDD52\uD835\uDD56\uD835\uDD64\uD835\uDD65\uD835\uDD63\uD835\uDD5A \uD835\uDD55\uD835\uDD56\uD835\uDD5D ℝ\uD835\uDD5A\uD835\uDD5F\uD835\uDD52\uD835\uDD64\uD835\uDD54\uD835\uDD5A\uD835\uDD5E\uD835\uDD56\uD835\uDD5F\uD835\uDD65\uD835\uDD60 \n");

        System.out.println("choose nickname:");
        nickname =stdin.nextLine();
        System.out.println("Welcome "+ nickname +", would you play SinglePlayer(s) or MultiPlayer(m)?");
        if(stdin.nextLine().equalsIgnoreCase("m") || stdin.nextLine().equalsIgnoreCase("multiplayer"))
            singleMulti=true;
        cLientController.updateInit(nickname,singleMulti);
    }
}

 */
