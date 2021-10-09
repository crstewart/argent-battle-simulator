package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/27/2019
 *
 * @author Craig
 */
public class ArchangelsWrath extends MagicAttack {

    private static final int SELF_DAMAGE_HP = 12;

    public ArchangelsWrath() {
        super();
        this.name = "Archangel's Wrath";
        this.description = "Deals 12 damage to the user";
        this.power = 80;
        this.variance = 10;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.takeDamage(SELF_DAMAGE_HP);
        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return owner.getHp() > SELF_DAMAGE_HP;
    }
}
