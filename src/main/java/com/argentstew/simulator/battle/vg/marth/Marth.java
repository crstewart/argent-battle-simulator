package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;
import com.argentstew.simulator.battle.vg.link.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marth
 * 8/27/2019
 *
 * @author Craig
 */
public class Marth {

    public static final String NAME = "Marth";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MELEE, 0.9);
        defenses.set(AttackType.RANGED, 0.9);
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.25);
        defenses.set(AttackSubType.HACK, 0.75);

        FighterStats stats = FighterStats.builder().strength(5).toughness(6).dexterity(7).aim(3)
                .agility(6).speed(6).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new DragonSlayer()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Marth: 'If you will allow me, I can be your strength!'",
                        "Marth: 'Everyone, watch over me!'"))
                .victoryQuotes(Arrays.asList("Marth: 'I cannot afford to lose!'",
                        "Marth: 'Let this be a ray of hope that lights the way for others!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Falchion()).addAction(new Rapier()).addAction(new Armorslayer())
                .addAction(new LevinSword())
                .addAction(new TrueFalchion())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
