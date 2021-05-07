package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Controller.MultiplayerGameManager;
import it.polimi.ingsw.Model.MultiplayerGame;
import it.polimi.ingsw.Model.Player;
import it.polimi.ingsw.Model.SinglePlayerFaithTrack;
import it.polimi.ingsw.Model.SinglePlayerGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private String nickname;

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void startClient(String nickname, Boolean Multi) throws IOException {

        Scanner stdin = new Scanner(System.in);                  //Usato per ricevere da tastiera
            Socket socket = new Socket(ip, port);
            System.out.println("Connection established");
            Scanner socketIn = new Scanner(socket.getInputStream()); //Usato per ricevere dal server
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream()); //Usato per inviare al Server
            socketOut.println(nickname);
            socketOut.println(Multi);

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
