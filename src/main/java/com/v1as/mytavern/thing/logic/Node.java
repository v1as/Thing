package com.v1as.mytavern.thing.logic;

public interface Node<State extends GameState, Character extends GameCharacter> {

    default void initialize(GameContext<State, Character> gameContext) {
    }

    NodeResults representation(GameContext<State, Character> gameContext);

}
