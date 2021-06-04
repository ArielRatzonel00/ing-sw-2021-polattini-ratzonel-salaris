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

    public void printMarketTray() {
        System.out.println("Col   " + "0 " + "1 " + "2 " + "3");
        for (int i = 0; i <= 2; i++) {
            if (i!=2)
                System.out.println("Row" + i + ": " + MarketMatrix[i][0].toString() + " " + MarketMatrix[i][1].toString() + " " + MarketMatrix[i][2].toString() + " " + MarketMatrix[i][3].toString() + " ←\n");
            else
                System.out.println("Row" + i + ": " + MarketMatrix[i][0].toString() + " " + MarketMatrix[i][1].toString() + " " + MarketMatrix[i][2].toString() + " " + MarketMatrix[i][3].toString() + " ←");

        }
        System.out.println("      " + "↑ " + "↑ " + "↑");
        System.out.println("Outside Marble: " + OustideMarble.toString());


    }

}