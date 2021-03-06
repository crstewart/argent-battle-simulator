package com.argentstew.simulator.battle.vg.erdrick;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;
import com.argentstew.simulator.battle.vg.sephiroth.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.erdrick
 * 3/29/2020
 *
 * @author argen
 */
public class Erdrick {

    public static final String NAME = "Erdrick";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.PIERCE, 0.8);

        FighterStats stats = FighterStats.builder().strength(6).toughness(6).dexterity(6).aim(6)
                .agility(5.5).speed(4.5).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new DragonSlayer()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(30).maxMp(30).xStrikeMeter(0)
                .description("An all-around fighter with magic power, healing, and dragon slaying potential.")
                .entryQuotes(Arrays.asList("The hero raises his sword in preparation for the battle.",
                        "The hero appears magically, appearing ready for a fight!"))
                .victoryQuotes(Arrays.asList("The hero does a wide slash and poses victoriously.",
                        "The hero kneels down and smiles, pleased to have won another battle."))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SwordOfKings()).addAction(new Frizz()).addAction(new Bang())
                .addAction(new Zap()).addAction(new Kaclang()).addAction(new Heal())
                .addAction(new Gigaslash())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
