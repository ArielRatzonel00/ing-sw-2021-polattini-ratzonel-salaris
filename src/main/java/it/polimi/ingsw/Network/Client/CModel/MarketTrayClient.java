package it.polimi.ingsw.Network.Client.CModel;

import it.polimi.ingsw.Model.Marble.MarketMarble;

public class MarketTrayClient {
    private MarketMarble[][] MarketMatrix = new MarketMarble[3][4];
    private MarketMarble OustideMarble;

    public MarketMarble[][] getMarketMatrix() {
        return MarketMatrix;
    }

    public void setMarketMatrix(MarketMarble[][] marketMatrix) {
        MarketMatrix = marketMatrix;
    }

    public MarketMarble getOustideMarble() {
        return OustideMarble;
    }

    public void setOustideMarble(MarketMarble oustideMarble) {
        OustideMarble = oustideMarble;
    }
}
