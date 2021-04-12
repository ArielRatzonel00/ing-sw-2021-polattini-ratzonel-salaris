package it.polimi.ingsw.Model;

public class ColoredMarble extends MarketMarble {
    private ColorMarble colorMarble;

    public ColoredMarble(ColorMarble colorMarble) {
        this.colorMarble = colorMarble;
    }

    public enum ColorMarble {
        GREY,
        YELLOW,
        PURPLE,
        BLUE
    }

    @Override
    public void EffectOfMarble(Player player) {
        System.out.println("Cosa vuoi fare con la Marble");
    }

    public ColorMarble getColorMarble() {
        return colorMarble;
    }
}
