package com.argentstew.simulator.battle.action;

import lombok.Data;

/**
 * com.argentstew.simulator.battle.action
 * 8/17/2019
 *
 * @author Craig
 */
@Data
public class AttackAction {

    private Action action = Action.ATTACK;
    private int damage;
    private boolean isCrit;
}
