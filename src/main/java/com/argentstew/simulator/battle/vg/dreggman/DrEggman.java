package com.argentstew.simulator.battle.vg.dreggman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.MechRider;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.tails.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dreggman
 * 3/28/2020
 *
 * @author argen
 */
public class DrEggman {

    public static final String NAME = "Dr. Eggman";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.4);
        defenses.set(AttackSubType.PUNCH, 1.2);
        defenses.set(AttackSubType.SLAM, 1.2);
        defenses.set(AttackSubType.HANDGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.8);
        defenses.set(AttackSubType.SHOTGUN, 0.8);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(6).dexterity(4).aim(5)
                .agility(3).speed(2).intellect(9).willpower(4).size(7).weight(8).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new MechRider()));
        return Fighter.builder().name(NAME).hp(170).maxHp(170).xStrikeMeter(0)
                .description("A mech-riding tank who antagonizes animal characters.")
                .entryQuotes(Arrays.asList("Dr. Eggman: 'Get a load of this!'",
                        "Dr. Eggman: 'Do you think you can beat me?'"))
                .victoryQuotes(Arrays.asList("Dr. Eggman: 'You will obey me! Or there will be dire consequences!'",
                        "Dr. Eggman: 'Hohoho! Success! A brilliant success!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.MECH))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new EggBomb()).addAction(new EggDrill()).addAction(new EggHammer())
                .addAction(new Flamethrower())
                .addAction(new DeathEgg())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
