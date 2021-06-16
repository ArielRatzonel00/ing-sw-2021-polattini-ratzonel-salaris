package it.polimi.ingsw.Network.Messages;

public class FinishSinglePlayerGame extends Message{
    boolean redWon = false;
    int totPoints = 0;
    public FinishSinglePlayerGame() {
        this.typeOfMessage = "FinishSinglePlayerGame";
    }

    public boolean isRedWon() {
        return redWon;
    }

    public void setRedWon(boolean redWon) {
        this.redWon = redWon;
    }

    public int getTotPoints() {
        return totPoints;
    }

    public void setTotPoints(int totPoints) {
        this.totPoints = totPoints;
    }
}
