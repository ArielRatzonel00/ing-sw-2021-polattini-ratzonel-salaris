package it.polimi.ingsw;

public class MarketMarble {
    private ColorMarble colorMarble;
    public MarketMarble(ColorMarble colorMarble) {
        this.colorMarble = colorMarble;
    }
    public enum ColorMarble {
        WHITE,
        RED,
        GREY,
        YELLOW,
        PURPLE,
        BLUE
    }
}


