package com.argentstew.simulator.battle.vg.nathandrake;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.vg.ratchet.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nathandrake
 * 4/3/2020
 *
 * @author argen
 */
public class NathanDrake {

    public static final String NAME = "Nathan Drake";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(6).aim(7)
                .agility(5).speed(5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter with a variety of guns at his disposal.")
                .entryQuotes(Arrays.asList("Nathan: 'Ah, crap.'", "Nathan: 'I'm not in Shambhala anymore...'"))
                .victoryQuotes(Arrays.asList("Nathan: 'I swear to God, if there's a zombie around the next corner...'",
                        "Nathan: 'Oh, you're gonna feel that in the morning!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new AK47()).addAction(new SAS12()).addAction(new MkNDIGrenade())
                .addAction(new SteelFist())
                .addAction(new EddysGoldenGun())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
