package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.trait.impl.GiantKiller;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/26/2019
 *
 * @author Craig
 */
public class Wander {

    public static final String FOUND_WEAK_SPOT = "Found Weak Spot";

    public static final String NAME = "Wander";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.DARK, 1.3);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(7.5).dexterity(8.5).aim(5)
                .agility(6).speed(5).intellect(5).willpower(7).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new GiantKiller(), new StealthDetection()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter with experience fighting colossal foes.")
                .entryQuotes(Arrays.asList("Dormin: 'Heed this: The price you pay may be heavy indeed.'",
                        "Wander: 'Please, I must bring back her soul.'"))
                .victoryQuotes(Arrays.asList("Dormin: 'Souls that are once lost cannot be reclaimed. Is that not the law of mortals?'",
                        "Wander: 'It doesn't matter.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new WanderStrategy()).build()
                .addAction(new AncientSword()).addAction(new AncientBow()).addAction(new GatherLight())
                .addAction(new StrikeWeakness())
                .addAction(new StrengthOfDormin())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
