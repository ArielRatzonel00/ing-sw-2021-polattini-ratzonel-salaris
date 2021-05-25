package it.polimi.ingsw.Model.LeaderCard;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Marble.MarketMarble;
import it.polimi.ingsw.Model.Player;

public class LeaderCard2 extends LeaderCard { //metodo per leader cards che diminuisce costo
    private int type;
    private DevelopmentCard.colorCard FirstcolorCost;
    private DevelopmentCard.colorCard SecondcolorCost;
    private MarketMarble.ColorMarble Discount;

    public LeaderCard2(int id, int victoryPoints, DevelopmentCard.colorCard FirstcolorCost, DevelopmentCard.colorCard SecondcolorCost, MarketMarble.ColorMarble Discount) {
        super(id, victoryPoints);
        type=2;
        this.FirstcolorCost = FirstcolorCost;
        this.SecondcolorCost = SecondcolorCost;
        this.Discount = Discount;
    }

    @Override
    public boolean canBeActivated(Player player) {
        if ((player.getSlotsBoard().filterCount(FirstcolorCost) >= 1) && (player.getSlotsBoard().filterCount(SecondcolorCost) >= 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String StampaCarta() {
        return "POTERE: Riduce costo delle DevCard di una risorsa di tipo: " + getDiscount() + "\n" +
                            "NECESSITA: 1 devCard colore " + getFirstcolorCost() + ", 1 devCard colore " + getSecondcolorCost() + "\n" +
                            "VICTORY POINTS: " + getVictoryPoints();
    }

    public DevelopmentCard.colorCard getFirstcolorCost() {
        return FirstcolorCost;
    }

    public DevelopmentCard.colorCard getSecondcolorCost() {
        return SecondcolorCost;
    }

    public MarketMarble.ColorMarble getDiscount() {
        return Discount;
    }
    public void effect(Player player){
        if (Discount == MarketMarble.ColorMarble.GREY){
            player.setDiscountGrey(1);
        }
        else if (Discount == MarketMarble.ColorMarble.YELLOW){
            player.setDiscountYellow(1);
        }
        else if (Discount == MarketMarble.ColorMarble.BLUE){
            player.setDiscountBlue(1);
        }
        else if (Discount == MarketMarble.ColorMarble.PURPLE){
            player.setDiscountPurple(1);
            }
        }
    @Override
    public String toString() {
        return "LeaderCard2{" +
                "victoryPoints=" + getVictoryPoints() +
                ", firstColorCost="+getFirstcolorCost() +
                ",secondColorCost="+getSecondcolorCost()+
                ",discount"+getDiscount()+
                '}';
    }
    @Override
    public int getType() {
        return 2;
    }
    }

