package it.polimi.ingsw.Model;
import java.util.arrayList;

public class Slots {
    private arrayList<DevelopmentCard> slot1; // possiamo crearlo di 3 posti questo array? // possiamo farlo direttamente con gli id?
    private arrayList <DevelopmentCard> slot2;
    private arrayList <DevelopmentCard> slot3;

    private int[] ColorDevCards = {0, 0, 0, 0}; //posizione 0: purple, 1=blue, 2=yellow, 3=green

    public <DevelopmentCard>

    public arrayList<DevelopmentCard> getSlot1() {
        return slot1;
    }

    public DevelopmentCard[] getCard2() {
        return slot2;
    }

    public DevelopmentCard[] getCard3() {
        return slot3;
    }

    public DevelopmentCard getCard1Top() {
        return slot1[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard2Top() {
        return slot2[0]; // verificare che sia effettivamente la 0 la più sopra
    }

    public DevelopmentCard getCard3Top() {
        return slot3[0]; // verificare che sia effettivamente la 0 la più sopra
    }


    public void setCard1(DevelopmentCard card1) {
        if(card1.getLevel()>=getCard1Top().getLevel())
        this.slot1 = card1;
    }

    public void setCard2(DevelopmentCard[] card2) {
        this.slot2 = card2;
    }

    public void setCard3(DevelopmentCard[] card3) {
        this.slot3 = card3;
    }

    public int[] getNumberOfDevCardsForColors(){ //da controllare bene
       for(int counter=0; counter < slot1.length; counter++)
       {
          if(slot1[counter].getColor() == DevelopmentCard.colorCard.Purple){
              ColorDevCards[0]+=1;
          }
          else{
              if(slot1[counter].getColor() == DevelopmentCard.colorCard.Blue){
                  ColorDevCards[1]+=1;
              }
              else{
                  if(slot1[counter].getColor() == DevelopmentCard.colorCard.Yellow){
                      ColorDevCards[2]+=1;
                  }
                  else{
                      if(slot1[counter].getColor() == DevelopmentCard.colorCard.Green){
                          ColorDevCards[3]+=1;
                      }
                  }
              }

          }
       }
        for(int c=0; c < slot2.length; c++)
        {
            if(slot2[c].getColor() == DevelopmentCard.colorCard.Purple){
                ColorDevCards[0]+=1;
            }
            else{
                if(slot2[c].getColor() == DevelopmentCard.colorCard.Blue){
                    ColorDevCards[1]+=1;
                }
                else{
                    if(slot2[c].getColor() == DevelopmentCard.colorCard.Yellow){
                        ColorDevCards[2]+=1;
                    }
                    else{
                        if(slot2[c].getColor() == DevelopmentCard.colorCard.Green){
                            ColorDevCards[3]+=1;
                        }
                    }
                }

            }
        }
        for(int counter=0; counter < slot3.length; counter++)
        {
            if(slot3[counter].getColor() == DevelopmentCard.colorCard.Purple){
                ColorDevCards[0]+=1;
            }
            else{
                if(slot3[counter].getColor() == DevelopmentCard.colorCard.Blue){
                    ColorDevCards[1]+=1;
                }
                else{
                    if(slot3[counter].getColor() == DevelopmentCard.colorCard.Yellow){
                        ColorDevCards[2]+=1;
                    }
                    else{
                        if(slot3[counter].getColor() == DevelopmentCard.colorCard.Green){
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
