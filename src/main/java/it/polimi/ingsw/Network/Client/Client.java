package it.polimi.ingsw.Network.Client;

import java.rmi.RemoteException;

public class Client {
    private final String ip;
    private int port;
    private final String username;


    public Client(String ip, int port, String username) {
        this.ip = ip;
        this.port = port;
        this.username = username;
    }

    private boolean active = true;

    public synchronized boolean isActive(){
        return active;
    }

    public synchronized void setActive(boolean active){
        this.active = active;
    }
    String getIp() {
        return ip;
    }

}
