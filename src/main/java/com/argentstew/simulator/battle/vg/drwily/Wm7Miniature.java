package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 8/27/2019
 *
 * @author Craig
 */
public class Wm7Miniature extends RangedAttack {

    public Wm7Miniature() {
        super();
        this.name = "WM7 Miniature";
        this.description = "Has a 50% chance to inflict virus status or 5% to inflict poison status for 5 turns";
        this.power = 70;
        this.variance = 10;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss()) {
            if (Math.random() < 0.5) {
                defender.setStatus(new StatusEffect(StatusType.VIRUS, 5));
            } else if (Math.random() < 0.05) {
                defender.setStatus(new StatusEffect(StatusType.POISON, 5));
            }
        }

        return damageReport;
    }
}
