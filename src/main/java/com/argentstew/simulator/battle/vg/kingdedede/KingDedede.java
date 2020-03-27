package com.argentstew.simulator.battle.vg.kingdedede;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingdedede
 * 8/27/2019
 *
 * @author Craig
 */
public class KingDedede {

    public static final String NAME = "King Dedede";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.95);
        defenses.set(AttackSubType.PIERCE, 1.15);
        defenses.set(AttackSubType.DARK, 1.15);

        FighterStats stats = FighterStats.builder().strength(7).toughness(3).dexterity(4).aim(4)
                .agility(3).speed(3).intellect(5).willpower(4).size(2).weight(2).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A brawler with powerful, inaccurate attacks.")
                .entryQuotes(Arrays.asList("King Dedede raises his hammer in the air and settles it on his shoulder.",
                        "King Dedede: 'Ha! You're going to love this.'"))
                .victoryQuotes(Arrays.asList("King Dedede: 'I'll be the one to keep the peace!'",
                        "King Dedede pats his belly and lets out a hearty laugh."))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new DededeHammer()).addAction(new Inhale()).addAction(new SuperDededeJump())
                .addAction(new WaddleDeeToss())
                .addAction(new DedeRush())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
