package com.argentstew.simulator.battle.reporting;

import com.argentstew.simulator.battle.action.AttackAction;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * com.argentstew.simulator.battle.reporting
 * 8/19/2019
 *
 * @author Craig
 */
@Data
@Builder
@NoArgsConstructor
public class DamageReport {

    private AttackAction attack;
    private int damage;
    private boolean isMiss;
    private boolean isCrit;
    private boolean isStun;
}
