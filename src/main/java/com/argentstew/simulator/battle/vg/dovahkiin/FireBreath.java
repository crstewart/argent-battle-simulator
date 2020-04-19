package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/27/2019
 *
 * @author Craig
 */
public class FireBreath extends RangedAttack {

    public FireBreath() {
        super();
        this.name = "Fire Breath (Yol Toor Shul)";
        this.description = "Has 25% additional critical hit chance";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.25;
    }
}
