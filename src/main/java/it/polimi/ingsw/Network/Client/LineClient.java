package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerFaithTrack;
import it.polimi.ingsw.Model.SinglePlayerGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LineClient {
    private String ip;
    private int port;
    private String nickname;

    public LineClient(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {

        Scanner stdin = new Scanner(System.in);                  //Usato per ricevere da tastiera

        System.out.println("Multiplayer (m) o Singleplayer (s) ?");

        //SinglePlayerGame, doesn't connect to Server;
        if (stdin.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Nickname:");
            nickname = stdin.nextLine();
            SinglePlayerGame SinglePlayer = new SinglePlayerGame(new Player(nickname, new SinglePlayerFaithTrack()));
            System.out.println("Welcome " + nickname + ", let's start the game!");
        }

        //MultiplayerGame, needs to connect to Server
        else {
            Socket socket = new Socket(ip, port);
            System.out.println("Multiplayer Connection established");
            Scanner socketIn = new Scanner(socket.getInputStream()); //Usato per ricevere dal server
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream()); //Usato per inviare al server

            try {
                while (true) {
                    String inputLine = stdin.nextLine();
                    socketOut.println(inputLine);
                    socketOut.flush();
                    String socketLine = socketIn.nextLine();
                    System.out.println(socketLine);
                }
            } catch (NoSuchElementException e) {
                System.out.println("Connection closed");
            } finally {
                stdin.close();
                socketIn.close();
                socketOut.close();
                socket.close();
            }
        }
    }

}
