package it.polimi.ingsw.Network.Messages;

public class MoveResourcesMessage extends Message{
   private int PlayerIndex = 0;
   private int row1 = 0;
   private int row2 = 0;

    public MoveResourcesMessage() {
        this.typeOfMessage = "MoveResourcesMessage";
    }

    public int getRow1() {
        return row1;
    }

    public void setRow1(int row1) {
        this.row1 = row1;
    }

    public int getRow2() {
        return row2;
    }

    public void setRow2(int row2) {
        this.row2 = row2;
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }
}
