package com.v1as.mytavern.thing.thing.nodes;

import static java.util.Collections.singletonList;

import com.v1as.mytavern.thing.logic.GameContext;
import com.v1as.mytavern.thing.logic.NodeResults;
import com.v1as.mytavern.thing.thing.ThingCharacter;
import com.v1as.mytavern.thing.thing.ThingNode;
import com.v1as.mytavern.thing.thing.ThingNodeLink;
import com.v1as.mytavern.thing.thing.ThingState;

public class FirstNode extends ThingNode {

    @Override
    public NodeResults<ThingState, ThingCharacter> getRepresentation(GameContext<ThingState, ThingCharacter> ctx) {
        ThingState state = ctx.getState();
        NodeResults<ThingState, ThingCharacter> nodeResults = new NodeResults<>();
        ThingCharacter chr = state.getCharForPlayer(ctx.getPlayer());
        StringBuilder text = new StringBuilder()
            .append("Приветствуем тебя игрок, сейчас ты ").append(chr.getRoleDescription())
            .append(".\n Твоя цель - ");
        if (chr.isThing()) {
            text.append("заразить всех людей.");
        } else if (chr.isInfected()) {
            text.append("помочь Нечто заразить всех оставшихся людей.");
        } else {
            text.append("выяснить кто нечто и сжечь его огнемётом.");
        }
        nodeResults.setText(text.toString());
        nodeResults.setLinks(singletonList(new ThingNodeLink("Поехали!", WaitNode.class)));
        return nodeResults;
    }

}
