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

    public boolean isDoable() {
        if (owner.getStatus() != null && owner.getStatus().getType().disallowsAction(this)) {
            return false;
        }

        return isAllowed();
    }

    public double calculateSpeed() {
        double calculatedSpeed = speed;
        for (Trait trait : owner.getTraits()) {
            calculatedSpeed = trait.applyBonusPriority(this, calculatedSpeed);
        }

        if (owner.getStatus() != null) {
            calculatedSpeed += owner.getStatus().getType().getPriorityChange();
        }

        return calculatedSpeed;
    }

    public abstract boolean isAllowed();

    public abstract double getFailureAdjustment();
}
