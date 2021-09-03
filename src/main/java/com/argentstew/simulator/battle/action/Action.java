package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/18/2019
 *
 * @author Craig
 */
@Data
@EqualsAndHashCode
public abstract class Action {

    protected String name;
    protected String description;
    protected ActionType type;
    protected Fighter owner;
    protected double speed;

    public abstract boolean isDoable();

    public double calculateSpeed() {
        double calculatedSpeed = speed;
        for (Trait trait : owner.getTraits()) {
            calculatedSpeed = trait.applyBonusPriority(this, calculatedSpeed);
        }

        return calculatedSpeed;
    }

    public abstract double getFailureAdjustment();
}
