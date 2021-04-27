package it.polimi.ingsw.Network.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(socket.getInputStream());          //Usato per ricevere dal client
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //USato per inviare al client

            while (true){
                String line = in.nextLine();
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
