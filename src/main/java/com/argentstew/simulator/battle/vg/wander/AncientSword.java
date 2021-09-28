package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/27/2019
 *
 * @author Craig
 */
public class AncientSword extends MeleeAttack {

    public AncientSword() {
        super();
        this.name = "Ancient Sword";
        this.description = "Has the light element when the X-Strike meter is lower than 10 and the dark element when greater";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        int damage = damageReport.getDamage();

        if (owner.getXStrikeMeter() < 10) {
            damage *= (int) Math.round(defender.getDefenses().get(AttackSubType.LIGHT));
        } else {
            damage *= (int) Math.round(defender.getDefenses().get(AttackSubType.DARK));
        }

        damageReport.setDamage(damage);
        return damageReport;
    }
}
