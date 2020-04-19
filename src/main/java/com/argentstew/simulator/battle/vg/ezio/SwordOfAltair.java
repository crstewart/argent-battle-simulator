package com.argentstew.simulator.battle.vg.ezio;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ezio
 * 8/27/2019
 *
 * @author Craig
 */
public class SwordOfAltair extends MeleeAttack {

    public SwordOfAltair() {
        super();
        this.name = "Sword of Altair";
        this.description = "Has 150% normal critical hit chance";
        this.power = 45;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritChance(Fighter defender) {
        return super.getCritChance(defender) * 1.5;
    }
}
