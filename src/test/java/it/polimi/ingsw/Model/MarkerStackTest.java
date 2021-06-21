package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Markers.PlusOneShuffleMarker;
import it.polimi.ingsw.Model.Markers.PlusTwoBlackMarker;
import it.polimi.ingsw.Model.Markers.RemoveCardsMarker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkerStackTest {
    private MarkerStack mark;

    @BeforeEach
    void initialization(){
        mark = new MarkerStack();
        mark.Shuffle();
    }

    @Test
    public void getTopMarkerTest(){
        if(mark.getTopMarker().equals(new PlusTwoBlackMarker())){
            assertSame(mark.getTopMarker(), new PlusTwoBlackMarker());
        }
        if(mark.getTopMarker().equals(new PlusOneShuffleMarker())){
            assertSame(mark.getTopMarker(), new PlusOneShuffleMarker());
        }
        if(mark.getTopMarker().equals(new RemoveCardsMarker(DevelopmentCard.colorCard.Green))){
            assertSame(mark.getTopMarker(), new RemoveCardsMarker(DevelopmentCard.colorCard.Green));
        }
    }

}
