package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.shovelknight.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 4/6/2020
 *
 * @author argen
 */
public class Sans {

    public static final String NAME = "Sans";
    public static final String TIRED_SELF_STATUS = "Tired";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);
        defenses.set(AttackSubType.SLASH, 1.25);

        FighterStats stats = FighterStats.builder().strength(3).toughness(4).dexterity(6).aim(9.5)
                .agility(6).speed(3).intellect(8.5).willpower(7.5).size(4).weight(3.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .description("A mage with perfect dodging potential. That is, until he tires out.")
                .entryQuotes(Arrays.asList("Sans: 'You're gonna have a bad time.'",
                        "Sans: 'You gotta learn when to QUIT. And that day's TODAY.'"))
                .victoryQuotes(Arrays.asList("Sans: 'It's a beautiful day outside. On days like these, people like you...should be burning in hell.'",
                        "Sans: 'Geeettttttt dunked on!!!'"))
                .classifications(Collections.singletonList(FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new BlueAttack()).addAction(new BoneAttack()).addAction(new GasterBlaster())
                .addAction(new FinalAttack())
                .addAction(new SansDodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
