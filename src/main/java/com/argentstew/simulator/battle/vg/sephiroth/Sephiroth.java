package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.kefka.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sephiroth
 * 3/29/2020
 *
 * @author argen
 */
public class Sephiroth {

    public static final String NAME = "Sephiroth";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(6).toughness(3).dexterity(7).aim(5)
                .agility(5.5).speed(5.5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .description("An all-around fighter whose attacks always land critical hits.")
                .entryQuotes(Arrays.asList("Sephiroth: 'Don't push your luck.'",
                        "Sephiroth: 'Can you stop me?'"))
                .victoryQuotes(Arrays.asList("Sephiroth: 'It's over. Everything. Everyone. Now everything will begin with me!'",
                        "Sephiroth: 'I want you to beg for forgiveness.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Masamune()).addAction(new Octaslash()).addAction(new ShadowFlare())
                .addAction(new Meteor()).addAction(new Scintilla())
                .addAction(new SuperNova())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
