package com.argentstew.simulator.battle.vg.kingkrool;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.CriticalArmor;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingkrool
 * 8/27/2019
 *
 * @author Craig
 */
public class KingKRool {

    public static final String NAME = "King K Rool";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.WATER, 0.7);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLAM, 1.2);
        defenses.set(AttackSubType.EXPLOSIVE, 1.3);

        FighterStats stats = FighterStats.builder().strength(8).toughness(9).dexterity(4).aim(4.5)
                .agility(2).speed(4).intellect(5).willpower(3).size(8).weight(9).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new CriticalArmor()));
        return Fighter.builder().name(NAME).hp(210).maxHp(210).xStrikeMeter(0)
                .description("A heavy tank with special armor that neutralizes the effectiveness of critical hits.")
                .entryQuotes(Arrays.asList("King K Rool crosses his arms and laughs at his opponent.",
                        "King K Rool pats his belly and stares down the opposing fighter."))
                .victoryQuotes(Arrays.asList("King K Rool shift his eyes and poses victoriously.",
                        "King K Rool stands over his fallen enemy and points at them tauntingly."))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Crownarang()).addAction(new Blunderbuss()).addAction(new Piledriver())
                .addAction(new GutCheck())
                .addAction(new Blastomatic())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
