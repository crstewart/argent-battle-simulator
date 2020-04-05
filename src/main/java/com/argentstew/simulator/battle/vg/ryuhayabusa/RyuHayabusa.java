package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.commandershepard.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryuhayabusa
 * 4/5/2020
 *
 * @author argen
 */
public class RyuHayabusa {

    public static final String NAME = "Ryu Hayabusa";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.CHI, 0.9);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(5).dexterity(7.5).aim(6.5)
                .agility(7).speed(6).intellect(5).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter whose ninjitsu allows him to bypass defenses.")
                .entryQuotes(Arrays.asList("Ryu Hayabusa: 'Those that stand against me are doomed to fail.'",
                        "Ryu Hayabusa: 'I will defeat all evil!'"))
                .victoryQuotes(Arrays.asList("Ryu Hayabusa: 'Fade into the depths of oblivion.'",
                        "Ryu Hayabusa: 'Those that stand in my way pay for it with their death. I will get my revenge!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new DragonSword()).addAction(new Shuriken()).addAction(new FireWheel())
                .addAction(new GuillotineThrow())
                .addAction(new EyeOfTheDragon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
