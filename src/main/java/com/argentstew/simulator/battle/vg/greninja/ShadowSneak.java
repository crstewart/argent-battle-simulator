package com.argentstew.simulator.battle.vg.greninja;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.Protean;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.greninja
 * 9/7/2019
 *
 * @author Craig
 */
public class ShadowSneak extends RangedAttack {

    public ShadowSneak() {
        super();
        this.name = "Shadow Sneak";
        this.power = 40;
        this.variance = 5;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        Protean trait = (Protean) this.owner.getTraits().getTraits().get(0);
        trait.setState(Protean.GHOST_TYPE);
        return super.doAttack(defender);
    }
}
