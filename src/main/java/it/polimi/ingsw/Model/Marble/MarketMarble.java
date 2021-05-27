package it.polimi.ingsw.Model.Marble;

import it.polimi.ingsw.Model.Player;

import java.io.Serializable;

public class MarketMarble implements Serializable {
    private MarketMarble.ColorMarble colorMarble;

    public MarketMarble(MarketMarble.ColorMarble colorMarble) {
        this.colorMarble = colorMarble;
    }

    public enum ColorMarble implements Serializable {
        GREY,
        YELLOW,
        PURPLE,
        BLUE,
        RED,
        WHITE,
        UNKNOWN
    }


    public MarketMarble.ColorMarble getColorMarble() {
        return colorMarble;
    }

}


