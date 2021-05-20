package it.polimi.ingsw.Network.Client;

import it.polimi.ingsw.Network.Messages.Message;
import it.polimi.ingsw.Network.Messages.Messanger;
import it.polimi.ingsw.Network.Messages.SocketMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client extends Messanger {

    private String ip;
    private int port;
    private int ID=1;
    private ObjectOutputStream socketOut;
    private ObjectInputStream socketIn;
    private ClientView clientView;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        
    }

    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    private boolean active = true;

    public synchronized boolean isActive() {
        return active;
    }

    public synchronized void setActive(boolean active) {
        this.active = active;
    }
    public synchronized void receiveMessage(SocketMessage message) throws IOException {
        if(message.getReceiver()==null || message.getReceiver().contains(this.ID)){
            System.out.println("entra nello switch");

            switch (message.getID()){
                case "abc":
                    System.out.println("funziona");
                    break;
                case "id:1":
                    this.ID=1;
                    sendMessage(socketOut, new SocketMessage("2Players",null));
                default:
                    break;
            }
        }
    }

    /*public Thread asyncReadFromSocket(final ObjectInputStream socketIn) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        Object inputObject = socketIn.readObject();
                        if (inputObject instanceof String) {
                            System.out.println((String) inputObject);
                        } else if (inputObject instanceof Board) {
                            ((Board) inputObject).print();
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }

    public Thread asyncWriteToSocket(final Scanner stdin, final PrintWriter socketOut) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isActive()) {
                        String inputLine = stdin.nextLine();
                        socketOut.println(inputLine);
                        socketOut.flush();
                    }
                } catch (Exception e) {
                    setActive(false);
                }
            }
        });
        t.start();
        return t;
    }
*/

    public void run() throws IOException {
        Socket socket = new Socket(ip, port);
        System.out.println("Connection established");
        socketOut = new ObjectOutputStream(socket.getOutputStream());
        socketIn=new ObjectInputStream(socket.getInputStream());
        Scanner stdin = new Scanner(System.in);

            try {
                System.out.println("Quanto vuoi che valga A?");
                int a=stdin.nextInt();
                socketOut.writeObject(a);

                SocketMessage b= (SocketMessage)socketIn.readObject();
                receiveMessage(b);
            } catch (NoSuchElementException | ClassNotFoundException e) {
                System.out.println("Connection closed from the client side");
            } finally {
                stdin.close();
                socketIn.close();
                socketOut.close();
                socket.close();
            }
    }
}

