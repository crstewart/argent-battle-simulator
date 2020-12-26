package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
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
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.SLASH, 0.7);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 1.5);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);
        defenses.set(AttackSubType.HACK, 0.5);

        FighterStats stats = FighterStats.builder().strength(5).toughness(6).dexterity(8.5).aim(4.5)
                .agility(6).speed(6).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new DragonSlayer()));
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A weaponmaster who takes extra damage from piercing attacks but resists hack attacks.")
                .entryQuotes(Arrays.asList("Marth: 'If you will allow me, I can be your strength!'",
                        "Marth: 'Everyone, watch over me!'"))
                .victoryQuotes(Arrays.asList("Marth: 'I cannot afford to lose!'",
                        "Marth: 'Let this be a ray of hope that lights the way for others!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new Falchion()).addAction(new Rapier()).addAction(new Armorslayer())
                .addAction(new LevinSword())
                .addAction(new TrueFalchion())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
