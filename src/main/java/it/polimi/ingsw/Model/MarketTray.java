package it.polimi.ingsw.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarketTray  {
    private MarketMarble[] ArrayMarble = new MarketMarble[13];
    private MarketMarble[][] MarketMatrix;
    private MarketMarble OustideMarble;

    public MarketTray() {
        ArrayMarble[0] = new MarketMarble (MarketMarble.ColorMarble.WHITE);
        ArrayMarble[1] = new MarketMarble (MarketMarble.ColorMarble.WHITE);
        ArrayMarble[2] = new MarketMarble (MarketMarble.ColorMarble.WHITE);
        ArrayMarble[3] = new MarketMarble (MarketMarble.ColorMarble.WHITE);
        ArrayMarble[4] = new MarketMarble (MarketMarble.ColorMarble.PURPLE);
        ArrayMarble[5] = new MarketMarble (MarketMarble.ColorMarble.PURPLE);
        ArrayMarble[6] = new MarketMarble (MarketMarble.ColorMarble.BLUE);
        ArrayMarble[7] = new MarketMarble (MarketMarble.ColorMarble.BLUE);
        ArrayMarble[8] = new MarketMarble (MarketMarble.ColorMarble.RED);
        ArrayMarble[9] = new MarketMarble (MarketMarble.ColorMarble.GREY);
        ArrayMarble[10] = new MarketMarble (MarketMarble.ColorMarble.GREY);
        ArrayMarble[11] = new MarketMarble (MarketMarble.ColorMarble.YELLOW);
        ArrayMarble[12] = new MarketMarble (MarketMarble.ColorMarble.YELLOW);
        List<MarketMarble> ListMarketMarble = Arrays.asList(ArrayMarble);
        Collections.shuffle(ListMarketMarble);
        ListMarketMarble.toArray(ArrayMarble);
        MarketMatrix[0][0] = ArrayMarble[0];
        MarketMatrix[0][1] = ArrayMarble[1];
        MarketMatrix[0][2] = ArrayMarble[2];
        MarketMatrix[0][3] = ArrayMarble[3];
        MarketMatrix[1][0] = ArrayMarble[4];
        MarketMatrix[1][1] = ArrayMarble[5];
        MarketMatrix[1][2] = ArrayMarble[6];
        MarketMatrix[1][3] = ArrayMarble[7];
        MarketMatrix[2][0] = ArrayMarble[8];
        MarketMatrix[2][1] = ArrayMarble[9];
        MarketMatrix[2][2] = ArrayMarble[10];
        MarketMatrix[2][3] = ArrayMarble[11];
        OustideMarble = ArrayMarble [12];
    }


    public MarketMarble[][] getMarketMatrix() {
        return MarketMatrix;
    }

    public MarketMarble getOustideMarble() {
        return OustideMarble;
    }

    public void ShiftMatrixByRow(int i, int j) {
        // pensare al codice da mettere qua

    }
    public void ShiftMatrixByCol(int i, int j) {
        // pensare al codice da mettere qua

    }
}
