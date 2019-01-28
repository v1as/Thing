package com.v1as.mytavern.thing.logic;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameContext<State extends GameState, Character extends GameCharacter> {

    private State state;
    private List<Character> characters;
    private List<Player> players;
    private Player player;

}
