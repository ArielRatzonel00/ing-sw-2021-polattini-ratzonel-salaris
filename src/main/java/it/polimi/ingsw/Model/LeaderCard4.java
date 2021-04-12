package it.polimi.ingsw.Model;

public class LeaderCard4 extends LeaderCards{ //converte in punto fede e materia a caso -> produzione extra
    public void canBeActivated(LeaderCard LeaderCardAct) {
        if(player.getSlots().getDevCardsLevel2(LeaderCardAct.getColor1Cost()) == true){
            LeaderCardAct.setActivate(true);
        }
    }
}
