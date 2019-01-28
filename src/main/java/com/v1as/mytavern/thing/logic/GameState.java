package com.v1as.mytavern.thing.logic;

import com.v1as.mytavern.thing.thing.ThingCharacter;
import java.util.List;

public interface GameState {

    void initialize(List<Player> players, List<ThingCharacter> characters);

}
