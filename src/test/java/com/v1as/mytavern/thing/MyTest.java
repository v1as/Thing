package com.v1as.mytavern.thing;

import static com.v1as.mytavern.thing.CollectionUtils.first;

import com.v1as.mytavern.thing.logic.GameContext;
import com.v1as.mytavern.thing.logic.NodeResults;
import com.v1as.mytavern.thing.logic.Player;
import com.v1as.mytavern.thing.thing.ThingCharacter;
import com.v1as.mytavern.thing.thing.ThingState;
import com.v1as.mytavern.thing.thing.nodes.FirstNode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class MyTest {

    int amount = 4;
    TestPlayerFactory playerFactory = new TestPlayerFactory();
    List<ThingCharacter> characters = IntStream
        .range(0, amount)
        .mapToObj(i -> new ThingCharacter())
        .collect(Collectors.toList());
    List<Player> players = playerFactory.players(amount);

    @Test
    public void test1() {
        ThingState state = new ThingState();
        state.initialize(players, characters);
        FirstNode firstNode = new FirstNode();
        GameContext<ThingState, ThingCharacter> ctx = new GameContext<>(state, characters,
            players, first(players));
        firstNode.initialize(ctx);
        NodeResults<ThingState, ThingCharacter> result = firstNode.getRepresentation(ctx);
        System.out.println(result);
    }
}
