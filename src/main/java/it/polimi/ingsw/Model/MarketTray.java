package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Marble.RedMarble;
import it.polimi.ingsw.Model.Marble.WhiteMarble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarketTray  {
    private MarketMarble[] ArrayMarble = new MarketMarble[13];
    private MarketMarble[][] MarketMatrix;
    private MarketMarble OustideMarble;

    public MarketTray() {
        ArrayMarble[0] = new WhiteMarble();
        ArrayMarble[1] = new WhiteMarble();
        ArrayMarble[2] = new WhiteMarble();
        ArrayMarble[3] = new WhiteMarble();
        ArrayMarble[4] = new ColoredMarble(ColoredMarble.ColorMarble.PURPLE);
        ArrayMarble[5] = new ColoredMarble (ColoredMarble.ColorMarble.PURPLE);
        ArrayMarble[6] = new ColoredMarble (ColoredMarble.ColorMarble.BLUE);
        ArrayMarble[7] = new ColoredMarble (ColoredMarble.ColorMarble.BLUE);
        ArrayMarble[8] = new RedMarble();
        ArrayMarble[9] = new ColoredMarble (ColoredMarble.ColorMarble.GREY);
        ArrayMarble[10] = new ColoredMarble (ColoredMarble.ColorMarble.GREY);
        ArrayMarble[11] = new ColoredMarble (ColoredMarble.ColorMarble.YELLOW);
        ArrayMarble[12] = new ColoredMarble (ColoredMarble.ColorMarble.YELLOW);

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

    public MarketMarble[] GetMarketMarblesFromRow(int row){

        MarketMarble[] returnedMarbles = new MarketMarble[4];
        returnedMarbles[0] = MarketMatrix[row][0];
        returnedMarbles[1] = MarketMatrix[row][1];
        returnedMarbles[2] = MarketMatrix[row][2];
        returnedMarbles[3] = MarketMatrix[row][3];
        return returnedMarbles;

    }
    public MarketMarble[] GetMarketMarblesFromCol(int col){

        MarketMarble[] returnedMarbles = new MarketMarble[3];
        returnedMarbles[0] = MarketMatrix[0][col];
        returnedMarbles[1] = MarketMatrix[1][col];
        returnedMarbles[2] = MarketMatrix[2][col];
        return returnedMarbles;

    }


    public void ShiftMatrixByRow(int rig) {
        MarketMarble temp = OustideMarble;
        OustideMarble = MarketMatrix[rig][0];
        MarketMatrix[rig][0] = MarketMatrix[rig][1];
        MarketMatrix[rig][1] = MarketMatrix[rig][2];
        MarketMatrix[rig][2] = MarketMatrix[rig][3];
        MarketMatrix[rig][3] =  temp;

    }
    public void ShiftMatrixByCol(int col) {
        MarketMarble temp2 = OustideMarble;
        OustideMarble = MarketMatrix[2][col];
        MarketMatrix[2][col] = MarketMatrix[1][col];
        MarketMatrix[1][col] = MarketMatrix[0][col];
        MarketMatrix[0][col] = temp2;

    }
}
