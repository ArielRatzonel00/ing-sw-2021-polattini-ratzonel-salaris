package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Markers.Marker;

import java.util.ArrayList;
import java.util.Collections;

public class MarkerStack {
    private ArrayList<Marker> markers;

    public MarkerStack(ArrayList<Marker> markers) {
        this.markers = markers;
        Collections.shuffle(markers);
    }


    public Marker getTopMarker(Marker[] markers, int CountForMarkerStack){
        return markers[CountForMarkerStack];
    }
    public void Shuffle(){
        Collections.shuffle(markers);

    }
}
