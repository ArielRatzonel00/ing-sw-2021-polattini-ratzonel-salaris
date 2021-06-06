package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.LeaderCard.LeaderCard1;
import it.polimi.ingsw.Model.Markers.Marker;
import it.polimi.ingsw.Model.Markers.PlusOneShuffleMarker;
import it.polimi.ingsw.Model.Markers.PlusTwoBlackMarker;
import it.polimi.ingsw.Model.Markers.RemoveCardsMarker;

import java.util.ArrayList;
import java.util.Collections;

//Class that represents the Stack of Markers in SinglePlayerGame

public class MarkerStack {
    private ArrayList<Marker> markers = new ArrayList<>();

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


    public Marker getTopMarker(){
        Marker temp = markers.get(markers.size()-1);
        markers.remove(markers.size()-1);
        markers.add(0, temp);
        return temp;
    } // Method that returns the TopMarket in the stack and put it at the bottom of the stack

    public ArrayList<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(ArrayList<Marker> markers) {
        this.markers = markers;
    }

    public void Shuffle(){
        Collections.shuffle(markers);
    } // Method that shuffle the Markers in the Stack
}
