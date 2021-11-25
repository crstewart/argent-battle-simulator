package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class Artillery extends RangedAttack {

    public Artillery() {
        super();
        this.name = "Artillery";
        this.description = "Reduces priority by 5 to equip";
        this.power = 80;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public double calculateSpeed() {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus())) {
            return super.calculateSpeed() + 5;
        }

        return super.calculateSpeed();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus())) {
            double rng = Math.random();
            owner.setSelfStatus((rng >= 0.5) ? MonsterHunter.WEAPON_BOWGUN : MonsterHunter.WEAPON_GUNLANCE);
        }

        return super.doAttack(defender);
    }
}
