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
        this(type, 100);
    }

    public StatusEffect(StatusType type, int turnsRemaining) {
        this.type = type;
        this.turnsRemaining = turnsRemaining + 1; // add 1 for resolution on turn status is applied
    }

    public void resolveTurn() {
        turnsRemaining--;
    }

    public void setForRemovalNextTurn() {
        turnsRemaining = 0;
    }

    public boolean hasEnded() {
        return turnsRemaining <= 0;
    }
}
