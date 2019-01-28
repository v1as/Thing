package com.v1as.mytavern.thing.thing;

import com.v1as.mytavern.thing.logic.GameCharacter;
import com.v1as.mytavern.thing.logic.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class ThingCharacter implements GameCharacter {

    private boolean infected = false;
    private Player player;
    private Map<CardType, Integer> cards = new HashMap<>();

    {
        Arrays.stream(CardType.values()).forEach(card -> cards.put(card, 0));
    }

    public void addCard(CardType card) {
        cards.put(card, cards.get(card) + 1);
    }

    public void popCard(CardType card) {
        cards.put(card, cards.get(card) - 1);
    }

    public boolean isThing() {
        return cards.get(CardType.THING) > 0;
    }

    public boolean isInfected() {
        return infected;
    }

    public boolean isThingTeam() {
        return isThing() || isInfected();
    }

    public String getRoleDescription() {
        if (isThing()) {
            return "Нечто";
        } else if (isInfected()) {
            return "заражённый";
        } else {
            return "человек";
        }
    }

}
