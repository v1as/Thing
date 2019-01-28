package com.v1as.mytavern.thing.logic;

import java.util.concurrent.TimeUnit;

public interface Actions<State extends GameState, Character extends GameCharacter> {

    void publicMessage(String message);

    void timeout(NodeLink<State, Character> link, TimeUnit unit, Integer value);

    void timeout(Player player, NodeLink<State, Character> link, TimeUnit unit, Integer value);

}
