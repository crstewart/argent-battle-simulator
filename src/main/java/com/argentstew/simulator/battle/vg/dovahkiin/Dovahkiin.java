package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;
import com.argentstew.simulator.battle.vg.ryuhayabusa.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 4/6/2020
 *
 * @author argen
 */
public class Dovahkiin {

    public static final String NAME = "Dovahkiin";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.9);
        defenses.set(AttackSubType.SLASH, 0.95);
        defenses.set(AttackSubType.PIERCE, 0.95);
        defenses.set(AttackSubType.HACK, 0.95);
        defenses.set(AttackSubType.SMASH, 0.95);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6).dexterity(6).aim(6.5)
                .agility(5).speed(4.5).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new DragonSlayer()));
        return Fighter.builder().name(NAME).hp(155).maxHp(155).xStrikeMeter(0)
                .description("An all-around fighter with an attack that pushes foes back and deals additional damage to heavyweights.")
                .entryQuotes(Arrays.asList("Dragonborn: 'Stand aside, or else.'",
                        "Dragonborn: 'Fine. Let me see if I can cut you down.'"))
                .victoryQuotes(Arrays.asList("Dragonborn: 'So what about my reward?'",
                        "Dragonborn: 'What is my destiny? I'm ready to learn.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SteelSword()).addAction(new UnrelentingForce()).addAction(new FireBreath())
                .addAction(new Sparks()).addAction(new SteelShield())
                .addAction(new CallDragon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
