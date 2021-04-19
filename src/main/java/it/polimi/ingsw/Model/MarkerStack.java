package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Markers.Marker;
import it.polimi.ingsw.Model.Markers.PlusOneShuffleMarker;
import it.polimi.ingsw.Model.Markers.PlusTwoBlackMarker;
import it.polimi.ingsw.Model.Markers.RemoveCardsMarker;

import java.util.ArrayList;
import java.util.Collections;

public class MarkerStack {
    private ArrayList<Marker> markers;

    public MarkerStack() {
        markers.add(new PlusTwoBlackMarker());
        markers.add(new PlusTwoBlackMarker());
        markers.add(new PlusOneShuffleMarker());
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Green));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Yellow));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Blue));
        markers.add(new RemoveCardsMarker(DevelopmentCard.colorCard.Purple));
        Collections.shuffle(markers);
    }


    public Marker getTopMarker(ArrayList<Marker> markers){
        Marker temp = markers.get(markers.size()-1);
        markers.remove(markers.size()-1);
        markers.add(temp);
        return temp;
    }
    public void Shuffle(){
        Collections.shuffle(markers);
    }
}
