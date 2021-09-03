package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.DemonicForm;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/27/2019
 *
 * @author Craig
 */
public class EyeBeam extends MagicAttack {

    public EyeBeam() {
        super();
        this.name = "Eye Beam";
        this.description = "Heals for 20% of the damage dealt while in demon form";
        this.power = 65;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        if (DemonicForm.DEMONIC_FORM_ENABLED_STATUS.equals(owner.getSelfStatus())) {
            this.owner.heal(report.getDamage() / 5);
        }

        return report;
    }
}
