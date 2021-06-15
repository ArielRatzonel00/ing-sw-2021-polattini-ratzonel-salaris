package it.polimi.ingsw.Network.Messages;

public class FinishMultiplayerGame extends Message{
    private String winnerPlayer;
    public FinishMultiplayerGame() {
        this.typeOfMessage = "FinishMultiplayerGame";
    }

    public String getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(String winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

}
