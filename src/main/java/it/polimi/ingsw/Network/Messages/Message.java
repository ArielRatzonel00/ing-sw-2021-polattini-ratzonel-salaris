package it.polimi.ingsw.Network.Messages;


import java.io.Serializable;
import java.util.List;

public abstract class Message implements Serializable {
 String typeOfMessage;
private List<Integer> receiver;


}
