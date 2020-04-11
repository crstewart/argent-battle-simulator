package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.kerrigan.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 4/4/2020
 *
 * @author argen
 */
public class Tracer {

    public static final String NAME = "Tracer";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(4).dexterity(8).aim(9)
                .agility(8).speed(7).intellect(5.5).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(0).maxMp(100).xStrikeMeter(0)
                .description("A futuristic speedy fighter with a powerful undodgeable attack that requires time to charge.")
                .entryQuotes(Arrays.asList("Tracer: 'Cheers, love! The cavalry's here!'",
                        "Tracer: 'Look out world! Tracer's here.'"))
                .victoryQuotes(Arrays.asList("Tracer: 'You got what's coming to ya!'",
                        "Tracer: 'You know, the world could always use more heroes.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new TracerStrategy()).build()
                .addAction(new PulsePistols()).addAction(new MeleeAttack()).addAction(new PulseBomb())
                .addAction(new Recall())
                .addAction(new CallOverwatch())
                .addAction(new Blink()).addAction(new Advance()).addAction(new Retreat());
    }
}
