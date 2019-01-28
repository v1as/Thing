package com.v1as.mytavern.thing.logic;

public interface GameLyfecycle<State extends GameState, Character extends GameCharacter> {

    GameContext<State, Character> preInitilize();

}
