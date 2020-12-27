package com.argentstew.simulator.battle.vg.sonic;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.arthur.*;
import com.argentstew.simulator.battle.vg.dreggman.DrEggman;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sonic
 * 3/28/2020
 *
 * @author argen
 */
public class Sonic {

    public static final String NAME = "Sonic";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.WATER, 1.2);

        FighterStats stats = FighterStats.builder().strength(3).toughness(3).dexterity(6).aim(4)
                .agility(8).speed(10).intellect(5).willpower(5).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new NaturalAgility(), new Hazardous(),
                new Rival(DrEggman.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter with hazardous quills and fast melee attacks who counters Dr. Eggman.")
                .entryQuotes(Arrays.asList("Sonic: 'Sonic's the name. Speed's my game.'",
                        "Sonic: 'Aw, yeah! This is happenin'!'"))
                .victoryQuotes(Arrays.asList("Sonic: 'That was almost too easy!'",
                        "Sonic: 'You need to be true to yourself.'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SpinDash()).addAction(new HomingAttack()).addAction(new WindUpPunch())
                .addAction(new TopKick())
                .addAction(new SuperSonic())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
