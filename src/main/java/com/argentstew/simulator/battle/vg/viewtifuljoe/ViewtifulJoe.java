package com.argentstew.simulator.battle.vg.viewtifuljoe;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.albertwesker.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.viewtifuljoe
 * 3/28/2020
 *
 * @author argen
 */
public class ViewtifulJoe {

    public static final String NAME = "Viewtiful Joe";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 0.9);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(3.5).dexterity(7.5).aim(8)
                .agility(7).speed(7).intellect(3.5).willpower(5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter whose ability to alter time leads to accurate attacks.")
                .entryQuotes(Arrays.asList("Joe: 'Henshin-A-Go-Go, baby!'", "Joe: 'Let's rock, baby, yeah!'"))
                .victoryQuotes(Arrays.asList("Joe: 'Man, I sure hope somebody caught that on camera.'",
                        "Joe: 'Whoa, that fight was simply viewtiful!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new RedHotKick()).addAction(new Voomerang()).addAction(new ShockingPink())
                .addAction(new VfxSlow())
                .addAction(new VfxMachSpeed())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
