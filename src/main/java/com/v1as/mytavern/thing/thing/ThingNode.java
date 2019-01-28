package com.v1as.mytavern.thing.thing;

import com.v1as.mytavern.thing.logic.GameContext;
import com.v1as.mytavern.thing.logic.Node;
import com.v1as.mytavern.thing.logic.NodeResults;
import com.v1as.mytavern.thing.logic.Player;
import java.util.List;

public abstract class ThingNode implements Node<ThingState, ThingCharacter> {

    private Player player;
    private ThingCharacter character;
    private GameContext<ThingState, ThingCharacter> ctx;


    public NodeResults representation(GameContext<ThingState, ThingCharacter> gameContext) {
        player = gameContext.getPlayer();
        character = gameContext.getState()
            .getCharacters()
            .stream()
            .filter(ch -> ch.getPlayer().equals(player))
            .findFirst().get();
        try {
            return getRepresentation(gameContext);
        } finally {
            player = null;
            character = null;
        }
    }

    protected abstract NodeResults<ThingState, ThingCharacter> getRepresentation(
        GameContext<ThingState, ThingCharacter> gameContext);

    protected Player player() {
        return player;
    }

    protected ThingCharacter character() {
        return character;
    }

    protected List<ThingCharacter> characters() {
        return ctx.getCharacters();
    }

    protected List<Player> players() {
        return ctx.getPlayers();
    }

}
