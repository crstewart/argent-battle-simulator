package com.argentstew.simulator.battle.vg.greninja;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.Protean;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.greninja
 * 8/27/2019
 *
 * @author Craig
 */
public class SecretNinjaTechnique extends MeleeXStrike {

    public SecretNinjaTechnique() {
        super();
        this.name = "Secret Ninja Technique";
        this.power = 240;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.WATER, AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        Protean trait = (Protean) this.owner.getTraits().getTraits().get(0);
        trait.setState(Protean.WATER_TYPE);
        return super.doAttack(defender);
    }
}
