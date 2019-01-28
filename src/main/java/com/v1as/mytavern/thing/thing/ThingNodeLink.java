package com.v1as.mytavern.thing.thing;

import com.v1as.mytavern.thing.logic.NodeLink;
import lombok.Data;

@Data
public class ThingNodeLink extends NodeLink<ThingState, ThingCharacter> {

    public ThingNodeLink(String text, Class<? extends ThingNode> clazz) {
        super(text, clazz);
    }

}
