package com.v1as.mytavern.thing;

import com.v1as.mytavern.thing.logic.Player;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestPlayerFactory {

    private long id = 0;

    Player player() {
        return new Player(id++, "name " + id, "nick" + id);
    }

    List<Player> players(int amount) {
        return IntStream.range(0, amount)
            .mapToObj(i -> player())
            .collect(Collectors.toList());
    }

}
