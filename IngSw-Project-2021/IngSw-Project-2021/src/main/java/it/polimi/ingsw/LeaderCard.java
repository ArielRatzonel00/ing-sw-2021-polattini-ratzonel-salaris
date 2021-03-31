package it.polimi.ingsw;

public class LeaderCard{
    private int requirements; //metodo di Luca
    private int VictoryPoints;
    private int SpecialAbility;//metodo di Luca
    private int act;

    public int getRequirements() {
        return requirements;
    }

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public int getSpecialAbility() {
        return SpecialAbility;
    }
    public void activate(){
        act = 1;
        //attivare carta Leader
    }
    public boolean isActivate(){
        if (act == 0){
            return false;
        }
        else {
            return true;
        }

    }
    public void discard(){
        // da rivedere

    }
}
