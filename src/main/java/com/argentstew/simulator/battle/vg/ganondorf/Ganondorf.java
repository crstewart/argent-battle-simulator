package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 8/27/2019
 *
 * @author Craig
 */
public class Ganondorf {

    public static final String NAME = "Ganondorf";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.LIGHT, 1.5);

        FighterStats stats = FighterStats.builder().strength(3.5).toughness(3).dexterity(7).aim(8)
                .agility(5).speed(4).intellect(8).willpower(8).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(200).maxHp(200).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Bowser: 'I'll show you the power of the Koopa King!'",
                        "Bowser: 'Stomping fools is my business!'"))
                .victoryQuotes(Arrays.asList("Bowser: 'I'm the biggest, baddest brute around, and don't you forget it.'",
                        "Bowser: 'What a total waste of time!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()

                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
