package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.trait.Trait;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/18/2019
 *
 * @author Craig
 */
@Data
@AllArgsConstructor
public class FighterTraits {

    private List<Trait> traits;

    public FighterTraits() {
        this.traits = new ArrayList<>();
    }

    public boolean has(Trait trait) {
        return traits != null && traits.contains(trait);
    }

    public boolean has(Class<? extends Trait> clazz) {
        return clazz != null && traits.stream().anyMatch(clazz::isInstance);
    }

    @SuppressWarnings({"unchecked"})
    public <T extends Trait> T getTrait(T trait) {
        if (trait == null) {
            return null;
        }

        return traits.stream().filter(t -> t.getName().equals(trait.getName())).map(t -> (T) t).findFirst()
                .orElse(null);
    }

    @SuppressWarnings({"unchecked"})
    public <T extends Trait> T getTrait(Class<T> clazz) {
        if (clazz == null) {
            return null;
        }

        return traits.stream().filter(clazz::isInstance).map(trait -> (T) trait).findFirst().orElse(null);
    }
}
