package it.polimi.ingsw.Network.Messages;


import java.io.Serializable;
import java.util.List;

public abstract class Message implements Serializable {
 String typeOfMessage;
private List<Integer> receiver;
int PlayerIndex = 0;

 public String getTypeOfMessage() {
  return typeOfMessage;
 }

 public void setPlayerIndex(int playerIndex) {
  PlayerIndex = playerIndex;
 }

 public int getPlayerIndex() {
  return PlayerIndex;
 }
}
