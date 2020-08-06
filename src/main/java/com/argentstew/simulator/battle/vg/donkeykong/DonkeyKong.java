package com.argentstew.simulator.battle.vg.donkeykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.donkeykong
 * 8/26/2019
 *
 * @author Craig
 */
public class DonkeyKong {

    public static final String NAME = "Donkey Kong";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MELEE, 1.1);
        defenses.set(AttackType.RANGED, 1.1);

        FighterStats stats = FighterStats.builder().strength(9).toughness(7.5).dexterity(3).aim(2)
                .agility(4).speed(3).intellect(1.5).willpower(5).size(8).weight(8).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(200).maxHp(200).mp(4).maxMp(4).xStrikeMeter(0)
                .description("A tank who fights overly aggressively, taking extra damage from many attacks.")
                .entryQuotes(Arrays.asList("DK pounds his chest and prepares for battle.",
                        "DK jumps onto the scene and slams the ground."))
                .victoryQuotes(Arrays.asList("DK does a backflip and flexes his arms.",
                        "DK clasps his hands above his head and shakes them in a victory pose."))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new GiantPunch()).addAction(new HandSlap()).addAction(new BarrelToss())
                .addAction(new RollAttack())
                .addAction(new JungleRush())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
