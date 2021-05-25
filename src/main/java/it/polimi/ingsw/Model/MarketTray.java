package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.MarketMarble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Class the represents the Market Tray

public class MarketTray  {
    private MarketMarble[] ArrayMarble = new MarketMarble[13];
    private MarketMarble[][] MarketMatrix = new MarketMarble[3][4];
    private MarketMarble OustideMarble;

    public MarketTray() {
        ArrayMarble[0] = new MarketMarble(MarketMarble.ColorMarble.WHITE);
        ArrayMarble[1] = new MarketMarble(MarketMarble.ColorMarble.WHITE);
        ArrayMarble[2] = new MarketMarble(MarketMarble.ColorMarble.WHITE);
        ArrayMarble[3] = new MarketMarble(MarketMarble.ColorMarble.WHITE);
        ArrayMarble[4] = new MarketMarble(MarketMarble.ColorMarble.PURPLE);
        ArrayMarble[5] = new MarketMarble (MarketMarble.ColorMarble.PURPLE);
        ArrayMarble[6] = new MarketMarble (MarketMarble.ColorMarble.BLUE);
        ArrayMarble[7] = new MarketMarble (MarketMarble.ColorMarble.BLUE);
        ArrayMarble[8] = new MarketMarble(MarketMarble.ColorMarble.RED);
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

    public MarketMarble[] GetMarketMarblesFromRow(int row){

        MarketMarble[] returnedMarbles = new MarketMarble[4];
        returnedMarbles[0] = MarketMatrix[row][0];
        returnedMarbles[1] = MarketMatrix[row][1];
        returnedMarbles[2] = MarketMatrix[row][2];
        returnedMarbles[3] = MarketMatrix[row][3];
        return returnedMarbles;

    } // Method that returns 4 marbles by selecting a row in the MarketTray

    public MarketMarble[] GetMarketMarblesFromCol(int col){

        MarketMarble[] returnedMarbles = new MarketMarble[3];
        returnedMarbles[0] = MarketMatrix[0][col];
        returnedMarbles[1] = MarketMatrix[1][col];
        returnedMarbles[2] = MarketMatrix[2][col];
        return returnedMarbles;

    } // Method that returns 3 marbles by selecting a column in the MarketTray


    public ArrayList<MarketMarble> ShiftMatrixByRow(int rig) {
        ArrayList<MarketMarble> returnedMarbles = new ArrayList<>();
        returnedMarbles.add(MarketMatrix[rig][0]);
        returnedMarbles.add(MarketMatrix[rig][1]);
        returnedMarbles.add(MarketMatrix[rig][2]);
        returnedMarbles.add(MarketMatrix[rig][3]);
        MarketMarble temp = OustideMarble;
        OustideMarble = MarketMatrix[rig][0];
        MarketMatrix[rig][0] = MarketMatrix[rig][1];
        MarketMatrix[rig][1] = MarketMatrix[rig][2];
        MarketMatrix[rig][2] = MarketMatrix[rig][3];
        MarketMatrix[rig][3] =  temp;
        return returnedMarbles;
    } //Method that shift the MarketTray after choosing to get Marbles by selected a row in the MarketTray


    public ArrayList<MarketMarble> ShiftMatrixByCol(int col) {
        ArrayList<MarketMarble> returnedMarbles = new ArrayList<>();
        returnedMarbles.add(MarketMatrix[2][col]);
        returnedMarbles.add(MarketMatrix[1][col]);
        returnedMarbles.add(MarketMatrix[0][col]);
        MarketMarble temp2 = OustideMarble;
        OustideMarble = MarketMatrix[2][col];
        MarketMatrix[2][col] = MarketMatrix[1][col];
        MarketMatrix[1][col] = MarketMatrix[0][col];
        MarketMatrix[0][col] = temp2;
        return returnedMarbles;

    } //Method that shift the MarketTray after choosing to get Marbles by selected a column in the MarketTray
}
