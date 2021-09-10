package com.argentstew.simulator.battle.status;

import lombok.Getter;

/**
 * com.argentstew.simulator.battle.status
 * 9/9/2021
 *
 * @author argen
 */
@Getter
public class StatusEffect {

    private final StatusType type;
    private int turnsRemaining;

    public StatusEffect(StatusType type) {
        this(type, Integer.MAX_VALUE);
    }

    public StatusEffect(StatusType type, int turnsRemaining) {
        this.type = type;
        this.turnsRemaining = turnsRemaining;
    }

    public void resolveTurn() {
        turnsRemaining--;
    }

    public boolean hasEnded() {
        return turnsRemaining <= 0;
    }
}
