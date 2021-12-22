package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait
 * 8/23/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class ColdResistance implements Trait {

    private final String name = "Cold Resistance";
    private final String description = "The fighter cannot be frostbitten.";

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
