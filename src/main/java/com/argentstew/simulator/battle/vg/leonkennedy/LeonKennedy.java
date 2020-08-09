package com.argentstew.simulator.battle.vg.leonkennedy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.akuma.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.leonkennedy
 * 3/28/2020
 *
 * @author argen
 */
public class LeonKennedy {

    public static final String NAME = "Leon Kennedy";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.HANDGUN, 0.9);
        defenses.set(AttackSubType.DARK, 0.8);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(5.5).aim(7.5)
                .agility(4.5).speed(5).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A modern fighter with an arsenal of firearms.")
                .entryQuotes(Arrays.asList("Leon: 'Okay, that's far enough! Don't move!'",
                        "Leon: 'Yeah, this is Raccoon City all over again.'"))
                .victoryQuotes(Arrays.asList("Leon: 'Is it just me, or does everybody always ignore what I say?'",
                        "Leon: 'Used to be a cop myself, only for a day, though.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new MatildaHandgun()).addAction(new W870Shotgun()).addAction(new ChemicalFlamethrower())
                .addAction(new SurvivalKnife())
                .addAction(new AntiTankRocket())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
