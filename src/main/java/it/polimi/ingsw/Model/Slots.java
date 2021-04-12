package it.polimi.ingsw.Model;

public class Slots {
    private DevelopmentCard[] card1; // possiamo crearlo di 3 posti questo array? // possiamo farlo direttamente con gli id?
    private DevelopmentCard[] card2;
    private DevelopmentCard[] card3;
    private int[] ColorDevCards = {0, 0, 0, 0}; //posizione 0: purple, 1=blue, 2=yellow, 3=green

    public DevelopmentCard[] getCard1() {
        return card1;
    }

    public DevelopmentCard[] getCard2() {
        return card2;
    }

    public DevelopmentCard[] getCard3() {
        return card3;
    }

    public DevelopmentCard getCard1Top() {
        return card1[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard2Top() {
        return card2[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard3Top() {
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

    public int[] getNumberOfDevCardsForColors(){ //da controllare bene
       for(int counter=0; counter < card1.length; counter++)
       {
          if(card1[counter].getColor() == DevelopmentCard.colorCard.Purple){
              ColorDevCards[0]+=1;
          }
          else{
              if(card1[counter].getColor() == DevelopmentCard.colorCard.Blue){
                  ColorDevCards[1]+=1;
              }
              else{
                  if(card1[counter].getColor() == DevelopmentCard.colorCard.Yellow){
                      ColorDevCards[2]+=1;
                  }
                  else{
                      if(card1[counter].getColor() == DevelopmentCard.colorCard.Green){
                          ColorDevCards[3]+=1;
                      }
                  }
              }

          }
       }
        for(int c=0; c < card2.length; c++)
        {
            if(card2[c].getColor() == DevelopmentCard.colorCard.Purple){
                ColorDevCards[0]+=1;
            }
            else{
                if(card2[c].getColor() == DevelopmentCard.colorCard.Blue){
                    ColorDevCards[1]+=1;
                }
                else{
                    if(card2[c].getColor() == DevelopmentCard.colorCard.Yellow){
                        ColorDevCards[2]+=1;
                    }
                    else{
                        if(card2[c].getColor() == DevelopmentCard.colorCard.Green){
                            ColorDevCards[3]+=1;
                        }
                    }
                }

            }
        }
        for(int counter=0; counter < card3.length; counter++)
        {
            if(card3[counter].getColor() == DevelopmentCard.colorCard.Purple){
                ColorDevCards[0]+=1;
            }
            else{
                if(card3[counter].getColor() == DevelopmentCard.colorCard.Blue){
                    ColorDevCards[1]+=1;
                }
                else{
                    if(card3[counter].getColor() == DevelopmentCard.colorCard.Yellow){
                        ColorDevCards[2]+=1;
                    }
                    else{
                        if(card3[counter].getColor() == DevelopmentCard.colorCard.Green){
                            ColorDevCards[3]+=1;
                        }
                    }
                }

            }
        }
       return ColorDevCards;
    }

}
   /* public void addCard(DevelopmentCard developmentCard){

    }
}

    */
