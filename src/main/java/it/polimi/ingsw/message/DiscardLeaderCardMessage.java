package it.polimi.ingsw.message;

public class DiscardLeaderCardMessage {
    private int PlayerIndex = 0;
    private int IndexLeaderCard1 = 0;
    private int IndexLeaderCard2 = 0;

    public int getPlayerIndex() {
        return PlayerIndex;
    }

    public void setPlayerIndex(int playerIndex) {
        PlayerIndex = playerIndex;
    }

    public int getIndexLeaderCard1() {
        return IndexLeaderCard1;
    }

    public void setIndexLeaderCard1(int indexLeaderCard1) {
        IndexLeaderCard1 = indexLeaderCard1;
    }

    public int getIndexLeaderCard2() {
        return IndexLeaderCard2;
    }

    public void setIndexLeaderCard2(int indexLeaderCard2) {
        int temp = 0;
        IndexLeaderCard2 = indexLeaderCard2;
        if (IndexLeaderCard2 < IndexLeaderCard1) {
            temp = IndexLeaderCard1;
            IndexLeaderCard1 = IndexLeaderCard2;
            IndexLeaderCard2 = temp;
        }

    }
}

