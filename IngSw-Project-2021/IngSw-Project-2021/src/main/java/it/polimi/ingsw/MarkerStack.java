package it.polimi.ingsw;

public class MarkerStack {
    private Marker[] markers;

    public MarkerStack(Marker[] markers) {
        // in modo random
        this.markers = markers;
    }

    public Marker getTopMarker(Marker[] markers){
        return markers[0];

    }
}
