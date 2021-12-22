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
public class ComboStrike implements Trait {

    private final String name = "Combo Strike";
    private final String description = "When stunning the opponent with an attack, the character gets a second " +
            "attack on the same turn for free.";
}
