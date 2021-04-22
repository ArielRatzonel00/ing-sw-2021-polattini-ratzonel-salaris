package it.polimi.ingsw.Model.Marble;

import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;

public class ColoredMarble extends MarketMarble {
    private ColorMarble colorMarble;

    public ColoredMarble(ColorMarble colorMarble) {
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


    public ColorMarble getColorMarble() {
        return colorMarble;
    }
}
