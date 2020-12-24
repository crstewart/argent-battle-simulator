package com.argentstew.simulator.battle.vg.cole;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.kratos.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.colemcgrath
 * 4/3/2020
 *
 * @author argen
 */
public class ColeMacgrath {

    public static final String NAME = "Cole MacGrath";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.THUNDER, 0.5);
        defenses.set(AttackSubType.EARTH, 1.1);
        defenses.set(AttackSubType.HANDGUN, 0.7);
        defenses.set(AttackSubType.SHOTGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.8);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(6.5).aim(6)
                .agility(7.5).speed(6.5).intellect(5).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter who charges all his attacks with electricity.")
                .entryQuotes(Arrays.asList("Cole: 'Let me introduce myself.'",
                        "Cole: 'You sure you want to face me?'"))
                .victoryQuotes(Arrays.asList("Cole: 'Now that's a butt-kicking. Is that all ya got?'",
                        "Cole: 'Powers don't kill people. Oh, no... It's the person behind the powers that kill people.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new LightningBolt()).addAction(new GigawattBlades()).addAction(new ThunderDrop())
                .addAction(new ShockGrenade())
                .addAction(new ElectricTornado())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
