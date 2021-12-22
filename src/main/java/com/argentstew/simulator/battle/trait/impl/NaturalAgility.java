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
public class NaturalAgility implements Trait {

    private final String name = "Natural Agility";
    private final String description = "The fighter cannot be paralyzed and can dodge bullet speed attacks.";

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
