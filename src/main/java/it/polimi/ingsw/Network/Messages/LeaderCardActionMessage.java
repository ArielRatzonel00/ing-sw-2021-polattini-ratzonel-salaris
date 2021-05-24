package it.polimi.ingsw.Network.Messages;

public class LeaderCardActionMessage extends Message{
    private int PlayerIndex = 0;
    private int NLeaderCard = 0;

    public LeaderCardActionMessage() {
        this.typeOfMessage = "LeaderCardActionMessage";
    }



    public int getNLeaderCard() {
        return NLeaderCard;
    }

    public void setNLeaderCard(int NLeaderCard) {
        this.NLeaderCard = NLeaderCard;
    }
}
