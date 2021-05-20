package it.polimi.ingsw.message;

public class LeaderCardActionMessage extends Message{
    private int PlayerIndex = 0;
    private int NLeaderCard = 0;

    public LeaderCardActionMessage() {
        this.typeOfMessage = "LeaderCardActionMessage";
    }

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    public int getNLeaderCard() {
        return NLeaderCard;
    }

    public void setNLeaderCard(int NLeaderCard) {
        this.NLeaderCard = NLeaderCard;
    }
}
