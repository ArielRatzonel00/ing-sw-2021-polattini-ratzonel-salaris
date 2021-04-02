package it.polimi.ingsw;

import java.util.Map;

public class LeaderCard {
    private int requirements; //metodo di Luca, dato che i requirments sono di diverso tipo li gestiamo con una tabella particolare da decidere insieme quando ci becchiamo
    private int VictoryPoints;
    private int SpecialAbility;//metodo di Luca, classe a parte per effetto
    // private int act; andrà nella funzione che chiama Active

    public int getRequirements() {
        return requirements;
    } // scorrere la tabella e vedere come pescare i requirments

    public int getVictoryPoints() {
        return VictoryPoints;
    }

    public int getSpecialAbility() {
        return SpecialAbility;
    } // scorrere Special Ability

    public boolean isActivate(int act) {
        if (act == 0) {
            return false;
        } else {
            return true;
        } // controllo se carta leader è da attivare

    }

}
/*
    public void discard(){
        // da rivedere, togliere la carta leader e fare add Faith Point

    }
    public void activate(){
        act = 1;
        //attivare carta Leader magari chimando i metodi della classe effetto da creare
        }


 */