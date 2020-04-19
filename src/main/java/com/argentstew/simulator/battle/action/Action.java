package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.fighter.Fighter;
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

    public abstract double calculateSpeed();

    public abstract double getFailureAdjustment();
}
