package it.polimi.ingsw.Network.Server;

import it.polimi.ingsw.Controller.MultiplayerGameManager;
import it.polimi.ingsw.Controller.SinglePlayerManager;
import it.polimi.ingsw.View.CLI;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Scanner;

public class SocketClientConnection extends Observable<String> implements ClientConnection, Runnable {
    private Socket socket;
    private ObjectOutputStream out;
    private Server server;
    private boolean active = true;

    /*SinglePlayerManager singlePlayerManager;
    MultiplayerGameManager multiplayerGameManager;
    String nickname;
    CLI cli;
*/
    public SocketClientConnection(Socket socket) {
        this.socket = socket;
    }

    public synchronized boolean isActive() {
        return active;
    }

    public synchronized void send(Object message) {
        try {
            out.reset();
            out.writeObject(message);
            out.flush();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public synchronized void closeConnection() {
        send("connection closed!");
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error when closing socket!");
        }
        active = false;
    }

    private void close() {
        closeConnection();
        System.out.println("Deregistering Client...");
        server.deregisterConnection(this);
        System.out.println("Done!");
    }

    @Override
    public void asyncSend(final Object message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                send(message);
            }
        }).start();
    }

    @Override
    public void run() {
        Scanner in;
        String name;
        try {
            in = new Scanner(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            send("Welcome!\nWhat is your nickname?");
            String read = in.nextLine();
            name = read;
            send("Do you want to play SinglePlayerGame or MultiPlayerGame(S/M)?");
            read = in.nextLine();
            if (read.equalsIgnoreCase("S")){
                Lobby.getInstance().
            }


            Lobby.getInstance.(this, name);
            while (isActive()) {
                read = in.nextLine();
                notify(read);
            }
        } catch (IOException | NoSuchElementException e) {
            System.err.println("Error!" + e.getMessage());
        } finally {
            close();
        }
    }
}



















    /*
    @Override
    public void run() {
        try {

            Scanner in = new Scanner(socket.getInputStream());          //Usato per ricevere dal client
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //USato per inviare al client
            nickname=in.nextLine();

            String line = in.nextLine();
            if(line.equalsIgnoreCase("s")) {
                singlePlayerManager = new SinglePlayerManager(nickname);
            }
            else{
                multiplayerGameManager=new MultiplayerGameManager();
            }
            while (true){
                line = in.nextLine();
                if(line.equals("quit")){
                    break;
                } else {
                    out.println("Received: " + line);
                    out.flush();
                }
            }
            //close connections
            in.close();
            out.close();
            socket.close();
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
*/