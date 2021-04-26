package it.polimi.ingsw.Model.Marble;

import it.polimi.ingsw.Model.Player;

public class MarketMarble {
    private MarketMarble.ColorMarble colorMarble;

    public MarketMarble(MarketMarble.ColorMarble colorMarble) {
        this.colorMarble = colorMarble;
    }

    public enum ColorMarble {
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


