package it.polimi.ingsw.Network.Messages;

public class ActivateLeaderCardActionMessage extends Message{
    int LeaderCardIndex = 0;
    public ActivateLeaderCardActionMessage() {
        this.typeOfMessage = "ActivateLeaderCardActionMessage";
    }

    public int getLeaderCardIndex() {
        return LeaderCardIndex;
    }

    public void setLeaderCardIndex(int leaderCardIndex) {
        LeaderCardIndex = leaderCardIndex;
    }
}
