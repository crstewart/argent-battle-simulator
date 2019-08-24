package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.trait.Trait;
import lombok.Data;

import java.util.List;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/18/2019
 *
 * @author Craig
 */
@Data
public class FighterTraits {

    private List<Trait> traits;

    public boolean has(Trait trait) {
        return traits != null && traits.contains(trait);
    }
}
