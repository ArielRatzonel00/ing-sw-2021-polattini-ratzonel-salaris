package it.polimi.ingsw.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
