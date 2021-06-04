package it.polimi.ingsw.Network.Messages;

public class DiscardLeaderCardActionMessage extends Message{
    int LeaderCardIndex = 0;
    public DiscardLeaderCardActionMessage() {
        this.typeOfMessage = "DiscardLeaderCardActionMessage";
    }

    public int getLeaderCardIndex() {
        return LeaderCardIndex;
    }

    public void setLeaderCardIndex(int leaderCardIndex) {
        LeaderCardIndex = leaderCardIndex;
    }
}
