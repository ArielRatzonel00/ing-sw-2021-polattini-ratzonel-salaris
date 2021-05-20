package it.polimi.ingsw.Network.Messages;

import java.util.List;

public class SocketMessage {
    String ID;
    private List<Integer> receiver;


    public SocketMessage(String ID, List<Integer> receiver) {
        this.ID=ID;
        this.receiver = receiver;
    }



    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public List<Integer> getReceiver() {
        return receiver;
    }
}


