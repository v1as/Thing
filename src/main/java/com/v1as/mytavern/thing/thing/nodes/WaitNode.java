package com.v1as.mytavern.thing.thing.nodes;

import com.v1as.mytavern.thing.logic.GameContext;
import com.v1as.mytavern.thing.logic.NodeResults;
import com.v1as.mytavern.thing.thing.ThingCharacter;
import com.v1as.mytavern.thing.thing.ThingNode;
import com.v1as.mytavern.thing.thing.ThingState;

public class WaitNode extends ThingNode {

    @Override
    public NodeResults getRepresentation(GameContext<ThingState, ThingCharacter> gameContext) {
        return new NodeResults();
    }
}
