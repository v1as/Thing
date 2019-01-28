package com.v1as.mytavern.thing.thing;

import com.v1as.mytavern.thing.logic.GameConfiguration;

public class ThingConfiguration implements GameConfiguration {

    public Integer minPlayers() {
        return 4;
    }

    public Integer maxPlayers() {
        return 12;
    }

}
