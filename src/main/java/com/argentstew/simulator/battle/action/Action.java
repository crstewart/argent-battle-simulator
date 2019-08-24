package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.action.ActionType;
import com.argentstew.simulator.battle.fighter.Fighter;
import lombok.Builder;
import lombok.Data;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/18/2019
 *
 * @author Craig
 */
@Data
public abstract class Action {

    protected ActionType type;
    protected Fighter owner;

    public abstract boolean isDoable();

    public abstract double getFailureAdjustment();
}
