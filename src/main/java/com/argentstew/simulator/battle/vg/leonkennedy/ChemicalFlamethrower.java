package com.argentstew.simulator.battle.vg.leonkennedy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class ChemicalFlamethrower extends RangedAttack {

    private int ammo;

    public ChemicalFlamethrower() {
        super();
        this.name = "Chemical Flamethrower";
        this.description = "100 ammo, each attack uses 25 ammo; applies burn status for three turns on hit";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.ammo = 100;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 25;
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.BURN, 3));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return ammo > 0;
    }
}
