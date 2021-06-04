package it.polimi.ingsw.Network.Messages;

public class EndTurnResponse extends Message{
    int IndexNewTurn;
    public EndTurnResponse() {
        this.typeOfMessage = "EndTurnResponse";
    }

    public int getIndexNewTurn() {
        return IndexNewTurn;
    }

    public void setIndexNewTurn(int indexNewTurn) {
        IndexNewTurn = indexNewTurn;
    }
}
