package com.argentstew.simulator.battle.vg.teemo;

import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.teemo
 * 3/28/2020
 *
 * @author argen
 */
public class Teemo {

    public static final String NAME = "Teemo";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);

        FighterStats stats = FighterStats.builder().strength(2).toughness(3).dexterity(6.5).aim(6.5)
                .agility(7).speed(7).intellect(6).willpower(6).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(125).maxHp(125).xStrikeMeter(0)
                .description("A speedy fighter who relies on stealth tactics to be effective.")
                .entryQuotes(Arrays.asList("Teemo: 'Captain Teemo on duty.'", "Teemo: 'Armed and ready.'"))
                .victoryQuotes(Arrays.asList("Teemo: 'Never underestimate the power of the Scout's code.'",
                        "Teemo: 'That's gotta sting.'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new BlowgunDarts()).addAction(new BlindingDart()).addAction(new ToxicShot())
                .addAction(new NoxiousTrap())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
