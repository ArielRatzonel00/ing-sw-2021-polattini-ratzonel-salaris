package it.polimi.ingsw;

import org.graalvm.compiler.virtual.phases.ea.EffectList;

import java.util.Map;

// da rivedere tutto
public class Marker {
    private int val; // numero dell'effetto (esempio 2 move forward, il 2)
    private MarkerEffect eff; // effetto quindi per esempio il move forward, crearsi la classe
    int i = 0;
    public int getVal() {
        return val;
    }

    public MarkerEffect getEff() {
        return eff;
    }

}

