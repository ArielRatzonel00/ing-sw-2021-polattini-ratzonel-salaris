/*
package it.polimi.ingsw.model;

import it.polimi.ingsw.Model.DevelopmentCard;
import it.polimi.ingsw.Model.Markers.Marker;
import it.polimi.ingsw.Model.Markers.PlusOneShuffleMarker;
import it.polimi.ingsw.Model.Markers.PlusTwoBlackMarker;
import it.polimi.ingsw.Model.Markers.RemoveCardsMarker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MarkerStackTest {

    @Test
    public void getTopMarkerTest(){
        ArrayList<Marker> markers = new ArrayList<>();
        markers.add(new PlusTwoBlackMarker());
        markers.add(new PlusTwoBlackMarker());
        markers.add(new PlusOneShuffleMarker());
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Green));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Yellow));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Blue));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Purple));
        assertSame(PlusOneShuffleMarker, markers.getTopMarker());
    }

}

 */