package it.polimi.ingsw.Network.Messages;

public class FourLeaderCardsMessage extends Message{
    private int PlayerIndex = 0;
    public FourLeaderCardsMessage() {
        this.typeOfMessage = "Four Leader Cards";
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
