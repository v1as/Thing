package com.v1as.mytavern.thing.thing;

import static java.util.Collections.shuffle;

import com.google.common.collect.ImmutableMap;
import com.v1as.mytavern.thing.logic.GameState;
import com.v1as.mytavern.thing.logic.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Getter;

@Getter
public class ThingState implements GameState {

    public static final int CARDS_AMOUNT = 4;
    private List<Player> players;
    private List<ThingCharacter> characters;
    private Map<Integer, Map<CardType, Integer>> CARDS = ImmutableMap.<Integer, Map<CardType, Integer>>builder()
        .put(4, ImmutableMap.<CardType, Integer>builder()
            .put(CardType.THING, 1)
            .put(CardType.INFECT, 8)
            .put(CardType.SUSPECTION, 4)
            .put(CardType.RUN, 2)
            .put(CardType.GOOD_HERE, 1)
            .put(CardType.DOOR, 1)
            .put(CardType.AXE, 1)
            .put(CardType.QUARANTINE, 1)
            .put(CardType.CHANGE_SIT, 2)
            .put(CardType.PERSISTENCE, 2)
            .put(CardType.WHISKEY, 1)
            .put(CardType.MISS, 1)
            .put(CardType.NO_THANK_YOU, 1)
            .put(CardType.NO_KEBAB, 1)
            .put(CardType.TEMPTATION, 2)
            .put(CardType.FLAMETHROWER, 2)
            .put(CardType.WATCH_AROUND, 1)
            .build())
        .build();
    private LinkedList<CardType> cards;

    public void initialize(List<Player> players, List<ThingCharacter> characters) {
        this.players = players;
        this.characters = characters;
        List<Player> playerList = new ArrayList<>(players);
        shuffle(playerList);
        Iterator<Player> getPlayer = playerList.iterator();
        characters.forEach(c -> c.setPlayer(getPlayer.next()));
        LinkedList<CardType> pool = createPool(players);
        shuffle(pool);
        int forPlayersAmount = players.size() * CARDS_AMOUNT - 1;
        List<CardType> forPlayers = new ArrayList<>(pool.subList(0, forPlayersAmount));
        pool = new LinkedList<>(pool.subList(forPlayersAmount, pool.size()));
        forPlayers.add(CardType.THING);
        shuffle(forPlayers);
        Integer infectedAmount = CARDS.get(players.size()).get(CardType.INFECT);
        for (int i = 0; i < infectedAmount; i++) {
            pool.add(CardType.INFECT);
        }
        shuffle(pool);
        for (ThingCharacter character : characters) {
            for (int i = 0; i < CARDS_AMOUNT; i++) {
                CardType card = forPlayers.remove(forPlayers.size() - 1);
                character.addCard(card);
            }
        }
        this.cards = pool;

    }

    private LinkedList<CardType> createPool(List<Player> players) {
        LinkedList<CardType> pool = new LinkedList<>();
        for (Entry<CardType, Integer> entry : CARDS.get(players.size()).entrySet()) {
            CardType key = entry.getKey();
            Integer number = entry.getValue();
            if (!CardType.THING.equals(key) && !CardType.INFECT.equals(key)) {
                for (int i = 0; i < number; i++) {
                    pool.add(key);
                }
            }
        }
        return pool;
    }

    public ThingCharacter getCharForPlayer(Player player) {
        return characters.get(players.indexOf(player));
    }
}
