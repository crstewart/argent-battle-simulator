package com.argentstew.simulator.battle.action;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AttackAction extends Action {

    private int damage;
    private boolean isCrit;
}
