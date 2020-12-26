package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.vg.handsomejack.*;
import com.argentstew.simulator.battle.vg.terry.TerryStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 4/4/2020
 *
 * @author argen
 */
public class Rayman {

    public static final String NAME = "Rayman";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.WATER, 0.7);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.GRAVITY, 0.8);

        FighterStats stats = FighterStats.builder().strength(6).toughness(5).dexterity(6.5).aim(6)
                .agility(5).speed(6).intellect(5).willpower(5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter who strikes with a variety of punches and kicks.")
                .entryQuotes(Arrays.asList("Rayman: 'No Problem!'", "Rayman: 'Ya-hoo!'"))
                .victoryQuotes(Arrays.asList("Rayman: 'Yeah-HOO! Yay me!'",
                        "Rayman does the air guitar and poses with a big grin."))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new MagicPunch()).addAction(new MagicKick()).addAction(new SpinningStrike())
                .addAction(new WindUpPunch())
                .addAction(new RaymanAlliedAssault())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
