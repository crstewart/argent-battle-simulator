package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.vg.dante.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 3/28/2020
 *
 * @author argen
 */
public class Arthur {

    public static final String NAME = "Arthur";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.85);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);

        FighterStats stats = FighterStats.builder().strength(4).toughness(8).dexterity(3).aim(9)
                .agility(3).speed(2).intellect(4.5).willpower(7.5).size(4).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Demonslayer()));
        return Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .description("A slow but steadfast fighter with all ranged attacks.")
                .entryQuotes(Arrays.asList("Arthur: 'Sir Arthur is ready to do battle!'",
                        "Arthur: 'I will fight you, fair and square!'"))
                .victoryQuotes(Arrays.asList("Arthur: 'Send forth the hordes! Sir Arthur will slay them!'",
                        "Arthur: 'A battle truly worthy of any of the Knights of the Round Table!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new LanceToss()).addAction(new DaggerToss()).addAction(new AxeToss())
                .addAction(new TorchToss()).addAction(new ShieldToss())
                .addAction(new GreatMagic())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
