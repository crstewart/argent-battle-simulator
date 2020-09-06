package com.argentstew.simulator.battle.vg.spyro;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.crash.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.spyro
 * 4/1/2020
 *
 * @author argen
 */
public class Spyro {

    public static final String NAME = "Spyro";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 0.8);
        defenses.set(AttackSubType.AIR, 1.2);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(6).dexterity(7).aim(7)
                .agility(7).speed(6.5).intellect(4).willpower(5).size(4).weight(3.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter with various elemental breath attacks.")
                .entryQuotes(Arrays.asList("Spyro: 'Looks like I got some things to do!'", "Spyro: 'All fired up!'"))
                .victoryQuotes(Arrays.asList("Spyro: 'I should go on vacation! Somewhere warm... Somewhere sunny...'",
                        "Spyro: 'That battle drained every last bit of my strength. I can hardly lift my head.'"))
                .classifications(Collections.singletonList(FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new FlameBreath()).addAction(new ElectricityBreath()).addAction(new WindBreath())
                .addAction(new Charge())
                .addAction(new SuperflameBreath())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
