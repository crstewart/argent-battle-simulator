package com.argentstew.simulator.battle.vg.bowser;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.vg.luigi.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/26/2019
 *
 * @author Craig
 */
public class Bowser {

    public static final String NAME = "Bowser";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 1.4);

        FighterStats stats = FighterStats.builder().strength(8).toughness(10).dexterity(2).aim(2)
                .agility(2).speed(2).intellect(3).willpower(6).size(8.5).weight(9).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Hazardous()));
        return Fighter.builder().name(NAME).hp(230).maxHp(230).xStrikeMeter(0)
                .description("A strong, tough tank whose spiked shell hurts melee attackers.")
                .entryQuotes(Arrays.asList("Bowser: 'I'll show you the power of the Koopa King!'",
                        "Bowser: 'Stomping fools is my business!'"))
                .victoryQuotes(Arrays.asList("Bowser: 'I'm the biggest, baddest brute around, and don't you forget it.'",
                        "Bowser: 'What a total waste of time!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new FireBreath()).addAction(new KoopaClaw()).addAction(new BowserBomb())
                .addAction(new FlyingSlam()).addAction(new WhirlingFortress())
                .addAction(new GiantBowserPunch())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
