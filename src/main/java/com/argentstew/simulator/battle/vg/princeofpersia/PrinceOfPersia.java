package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.vg.ezio.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 4/4/2020
 *
 * @author argen
 */
public class PrinceOfPersia {

    public static final String NAME = "Prince of Persia";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.PLASMA, 1.2);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5.5).dexterity(7).aim(7)
                .agility(8.5).speed(7).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A speedy fighter who can reverse time to heal wounds.")
                .entryQuotes(Arrays.asList("The Prince: 'Have you been waiting long?'",
                        "The Prince: 'How long have I been gone?'"))
                .victoryQuotes(Arrays.asList("The Prince: 'Never trust a man who betrays his master, lest he betray you as well.'",
                        "The Prince: 'I have seen the face of time, and I can tell you: Time is an ocean in a storm.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new DaggerOfTime()).addAction(new PrincesSword()).addAction(new Gauntlet())
                .addAction(new Bow()).addAction(new ReverseTime())
                .addAction(new PowerOfTheDjinn())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
