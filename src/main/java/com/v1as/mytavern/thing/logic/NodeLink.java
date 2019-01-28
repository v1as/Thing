package com.v1as.mytavern.thing.logic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeLink<State extends GameState, Character extends GameCharacter> {

    private String text;
    private Class<? extends Node> clazz;

    public void execute(GameContext<State, Character> gameContext) {
    }

}
