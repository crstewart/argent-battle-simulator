package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterTraits;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class EndlessTorment implements Trait {

    private final String name = "Endless Torment";

    @Override
    public void applyStartOfGameEffects(Fighter owner, Fighter defender) {
        List<Trait> traitList = new ArrayList<>();
        for (Trait trait : defender.getTraits()) {
            if (trait.isImmuneToTorment()) {
                traitList.add(trait);
            }
        }

        defender.setTraits(new FighterTraits(traitList));
    }
}
