package it.polimi.ingsw.Network.Messages;

public class EndTurnMessage extends Message{
    int IndexNewTurn;
    public EndTurnMessage() {
        this.typeOfMessage = "EndTurn";
    }

    public int getIndexNewTurn() {
        return IndexNewTurn;
    }

    public void setIndexNewTurn(int indexNewTurn) {
        IndexNewTurn = indexNewTurn;
    }
}
