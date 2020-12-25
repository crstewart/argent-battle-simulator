package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.pit.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.inkling
 * 3/26/2020
 *
 * @author argen
 */
public class Inkling {

    public static final String NAME = "Inkling";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.WATER, 1.5);

        FighterStats stats = FighterStats.builder().strength(3).toughness(2.5).dexterity(9).aim(9)
                .agility(6.5).speed(5).intellect(4).willpower(4).size(3.5).weight(3.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(100).maxMp(100).xStrikeMeter(0)
                .description("A weaponmaster whose ink attacks deal extra damage to those with weakness to poison.")
                .entryQuotes(Arrays.asList("Inkling: 'Ready!'", "Inkling: 'Yes!'"))
                .victoryQuotes(Arrays.asList("Inkling: 'Booyah!'", "Inkling: 'Woomy!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new InklingStrategy()).build()
                .addAction(new Splattershot()).addAction(new SplatRoller()).addAction(new SplatCharger())
                .addAction(new SplatBomb()).addAction(new RefillInk())
                .addAction(new KillerWail())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
