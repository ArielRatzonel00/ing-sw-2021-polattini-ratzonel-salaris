package it.polimi.ingsw.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MarkerStack {
    private Marker[] markers;

    public MarkerStack(Marker[] markers) {

        this.markers = markers;
        List<Marker> ListMarkers = Arrays.asList(markers);
        Collections.shuffle(ListMarkers);
        ListMarkers.toArray(markers);
    }


    public Marker getTopMarker(Marker[] markers, int CountForMarkerStack){
        return markers[CountForMarkerStack];

    }
}
