package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class ExMaverickHunter implements Trait {

    private final String name = "Ex-Maverick Hunter";
    private final String description = "The fighter deals double damage to humanoids and inflicts virus status on " +
            "the first successful attack.";

    private boolean activated;

    public ExMaverickHunter() {
        this.activated = false;
    }

    @Override
    public boolean isImmuneToTorment() {
        return false;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
