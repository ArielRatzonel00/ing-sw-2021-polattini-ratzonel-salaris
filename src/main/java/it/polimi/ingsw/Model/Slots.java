package it.polimi.ingsw.Model;

public class Slots {
    private DevelopmentCard[] card1; // possiamo crearlo di 3 posti questo array? // possiamo farlo direttamente con gli id?
    private DevelopmentCard[] card2;
    private DevelopmentCard[] card3;

    public DevelopmentCard[] getCard1() {
        return card1;
    }

    public DevelopmentCard[] getCard2() {
        return card2;
    }

    public DevelopmentCard[] getCard3() {
        return card3;
    }

    public DevelopmentCard getCard1Top() { // metodo aggiunto per avere le carte più in alto per fare la produzione
        return card1[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard2Top() { // metodo aggiunto per avere le carte più in alto per fare la produzione
        return card2[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard3Top() { // metodo aggiunto per avere le carte più in alto per fare la produzione
        return card3[0]; // verificare che sia effettivamente la 0 la più sopra
    }


    public void setCard1(DevelopmentCard[] card1) {
        this.card1 = card1;
    }

    public void setCard2(DevelopmentCard[] card2) {
        this.card2 = card2;
    }

    public void setCard3(DevelopmentCard[] card3) {
        this.card3 = card3;
    }
}
   /* public void addCard(DevelopmentCard developmentCard){

    }
}

    */
