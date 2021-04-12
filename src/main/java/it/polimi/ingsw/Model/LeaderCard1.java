package it.polimi.ingsw.Model;

public class LeaderCard1 extends LeaderCards { //metodo per leader cards che trasformano pallina bianca in altri colori
    private int[] SlotCards = new int[4];
    @Override
    public void canBeActivated(LeaderCard LeaderCardAct) {
        SlotCards = player.getSlots().getNumberOfDevCardsForColors();
        if(LeaderCardAct.getColor1Cost()==1 && SlotCards[0]>=2 && LeaderCardAct.getColor2()==4 && SlotCards[3]>=1){
            LeaderCardAct.setActivate(true);
        }

        if(LeaderCardAct.getColor1Cost()==4 && SlotCards[3]>=2 && LeaderCardAct.getColor2()==1 && SlotCards[0]>=1){
            LeaderCardAct.setActivate(true);
        }

        if(LeaderCardAct.getColor1Cost()==3 && SlotCards[2]>=2 && LeaderCardAct.getColor2()==2 && SlotCards[1]>=1){
            LeaderCardAct.setActivate(true);
        }

        if(LeaderCardAct.getColor1Cost()==2 && SlotCards[1]>=2 && LeaderCardAct.getColor2()==3 && SlotCards[2]>=1){
            LeaderCardAct.setActivate(true);
        }

    }
}
