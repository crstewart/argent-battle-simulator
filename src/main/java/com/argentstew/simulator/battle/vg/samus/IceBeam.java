package com.argentstew.simulator.battle.vg.samus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samus
 * 11/10/2019
 *
 * @author Craig
 */
public class IceBeam extends RangedAttack {

    public IceBeam() {
        super();
        this.name = "Ice Beam";
        this.description = "Applies frostbite status for three turns on hit";
        this.power = 70;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.FROSTBITE, 3));
        }

        return damageReport;
    }
}
