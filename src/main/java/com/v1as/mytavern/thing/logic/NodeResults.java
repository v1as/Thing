package com.v1as.mytavern.thing.logic;

import java.util.List;
import lombok.Data;

@Data
public class NodeResults<State extends GameState, Character extends GameCharacter> {

    private String text;
    private List<? extends NodeLink<State,Character>> links;
    private NodeLink<State, Character> forward;


}
