package it.polimi.ingsw.Model.Markers;

import it.polimi.ingsw.Model.Model;

import java.io.Serializable;

public abstract class Marker implements Serializable {
    public int MarkerEffect(Model game){
        return 0;
    }

    public String getType()
    {
        return "";
    }

}

