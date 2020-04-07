package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 4/6/2020
 *
 * @author argen
 */
public class SansDodge extends Dodge {

    public SansDodge() {
        super();
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        if (attack == null) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.UNDODGEABLE)) {
            return false;
        }

        if (!Sans.TIRED_SELF_STATUS.equals(owner.getSelfStatus())) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.BULLET_SPEED) && !owner.getTraits().has(new NaturalAgility())) {
            return false;
        }

        return Math.random() < (owner.getStats().getSpeed() * 0.0275 + owner.getStats().getAgility() * 0.0475);
    }
}
