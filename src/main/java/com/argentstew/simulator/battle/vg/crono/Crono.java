package com.argentstew.simulator.battle.vg.crono;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.sora.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 3/30/2020
 *
 * @author argen
 */
public class Crono {

    public static final String NAME = "Crono";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.DARK, 1.2);

        FighterStats stats = FighterStats.builder().strength(6).toughness(4.5).dexterity(6).aim(6)
                .agility(6).speed(5).intellect(4).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(16).maxMp(16).xStrikeMeter(0)
                .description("An all-around fighter with melee, ranged, and magic attacks.")
                .entryQuotes(Arrays.asList("Crono pulls out his katana and take a fighting stance.'",
                        "Crono blinks and looks confused at his opponent.'"))
                .victoryQuotes(Arrays.asList("Crono puts away his katana and does a fist pump.'",
                        "Crono revels in victory with his friends!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Katana()).addAction(new WindSlash()).addAction(new Lightning())
                .addAction(new Cleave())
                .addAction(new Luminaire())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
