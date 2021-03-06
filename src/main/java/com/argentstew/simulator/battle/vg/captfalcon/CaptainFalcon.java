package com.argentstew.simulator.battle.vg.captfalcon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.BountyHunter;
import com.argentstew.simulator.battle.vg.ness.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captfalcon
 * 8/27/2019
 *
 * @author Craig
 */
public class CaptainFalcon {

    public static final String NAME = "Captain Falcon";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(6).toughness(5).dexterity(6).aim(2)
                .agility(5).speed(6).intellect(5).willpower(4.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new BountyHunter()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A speedy all-around fighter with standard defenses whose attacks are all on fire.")
                .entryQuotes(Arrays.asList("Captain Falcon: 'Show me your moves!'",
                        "Captain Falcon: 'C'mon!'"))
                .victoryQuotes(Arrays.asList("Captain Falcon: 'You don't win by being lucky - you win by being bold!'",
                        "Captain Falcon: 'There are two kinds of drivers in this race... me, and the losers!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new FalconPunch()).addAction(new FalconKick()).addAction(new FalconDive())
                .addAction(new RaptorBoost())
                .addAction(new BlueFalcon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
