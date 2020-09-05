package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;
import com.argentstew.simulator.battle.vg.dovahkiin.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 4/6/2020
 *
 * @author argen
 */
public class ShovelKnight {

    public static final String NAME = "Shovel Knight";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.WATER, 0.8);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(3).dexterity(5.5).aim(5.5)
                .agility(4).speed(3.5).intellect(3.5).willpower(5).size(4).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(40).maxMp(40).xStrikeMeter(0)
                .description("An all-around fighter who is a mix of tank, brawler, and mage.")
                .entryQuotes(Arrays.asList("Shovel Knight: 'Stand aside! I've no quarrel with you.'",
                        "Shovel Knight: 'Prepare to taste justice! Shovel justice!'"))
                .victoryQuotes(Arrays.asList("Shovel Knight: 'Knights are strongest when they work together!'",
                        "Shovel Knight: 'Well fought. If you can accept defeat like a true knight, you'll always have your dignity.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ShovelBlade()).addAction(new ChargeAttack()).addAction(new FlareWand())
                .addAction(new ChaosSphere()).addAction(new DustKnuckles()).addAction(new PhaseLocket())
                .addAction(new WarHorn())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
