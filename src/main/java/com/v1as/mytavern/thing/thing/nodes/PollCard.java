package com.v1as.mytavern.thing.thing.nodes;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.v1as.mytavern.thing.logic.GameContext;
import com.v1as.mytavern.thing.logic.NodeResults;
import com.v1as.mytavern.thing.thing.CardType;
import com.v1as.mytavern.thing.thing.ThingCharacter;
import com.v1as.mytavern.thing.thing.ThingNode;
import com.v1as.mytavern.thing.thing.ThingNodeLink;
import com.v1as.mytavern.thing.thing.ThingState;
import java.util.Map;
import java.util.Map.Entry;

public class PollCard extends ThingNode {

    @Override
    public void initialize(GameContext<ThingState, ThingCharacter> gameContext) {
        CardType cardType = gameContext.getState().getCards().pollFirst();
        character().setLastCard(cardType);
        Map<CardType, Integer> cards = character().getCards();
        cards.put(cardType, cards.getOrDefault(cardType, 0) + 1);
    }

    @Override
    protected NodeResults<ThingState, ThingCharacter> getRepresentation(
        GameContext<ThingState, ThingCharacter> gameContext) {
        NodeResults<ThingState, ThingCharacter> result = new NodeResults<>();
        result.setText("Вы вытянули карту " + character().getLastCard() + ".\n Какие ваши дальнейшие действия?");
        Builder<ThingNodeLink> builder = ImmutableList.builder();
        character().getCards().entrySet().stream()
            .filter(e -> e.getValue() > 0)
            .map(e -> new ThingNodeLink(e.getKey().getShortName() + " x" + e.getValue(), ExecuteCard.class))
            .forEach(builder::add);
        builder.add(new ThingNodeLink("Выбросить одну из карт", DropCard.class));
        result.setLinks(builder.build());
        return result;
    }
}
