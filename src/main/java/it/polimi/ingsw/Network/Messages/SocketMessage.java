package it.polimi.ingsw.Network.Messages;

import java.io.Serializable;
import java.util.List;

public class SocketMessage implements Serializable {
    private static final long serialVersionUID = 6589184250663958343L;
    String ID;
    private List<String> receiver;
    private int value;
    private String sender;


    public SocketMessage(String ID, int value, List<String> receiver,String sender) {
        this.ID=ID;
        this.receiver = receiver;
        this.value=value;
        this.sender=sender;
    }


   @Override
    public String toString() {
        String receiverString = receiver.toString();

        return "Message{" +
                "ID=" + ID +
                ", value=" + value +
                "receivers="+receiverString+
                "sender="+sender+
                '}';
    }

    public String getSender() {
        return sender;
    }

    public int getValue() {
        return value;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public List<String> getReceiver() {
        return receiver;
    }
}


