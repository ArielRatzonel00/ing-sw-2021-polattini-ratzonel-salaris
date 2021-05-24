package it.polimi.ingsw.Network.Messages;

public class EndOfTurnMessage extends Message{
    public EndOfTurnMessage() {
        this.typeOfMessage = "EndOfTurnMessage";
    }
    private int PlayerIndex = 0;

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
