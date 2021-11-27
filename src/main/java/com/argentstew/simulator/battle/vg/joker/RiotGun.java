package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class RiotGun extends RangedAttack {

    public RiotGun() {
        super();
        this.name = "Riot Gun";
        this.description = "Requires a summoned persona";
        this.power = 120;
        this.variance = 10;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public boolean isAllowed() {
        return StringUtils.isNotBlank(owner.getSelfStatus());
    }
}
