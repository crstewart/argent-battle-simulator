package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 9/7/2019
 *
 * @author Craig
 */
public class BraveBird extends MeleeAttack {

    public BraveBird() {
        super();
        this.name = "Brave Bird";
        this.description = "Deals 33% recoil damage to the user";
        this.power = 120;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.AIR, AttackSubType.WING);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        int recoil = (int) Math.round(damageReport.getDamage() / 3.0);
        owner.takeDamage(recoil);
        if (defender.getHp() - damageReport.getDamage() <= 0 && owner.getHp() <= 0) {
            owner.setHp(1);
        }

        return damageReport;
    }
}
