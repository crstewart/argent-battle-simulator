package com.argentstew.simulator.battle.vg.laracroft;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.banjo.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.laracroft
 * 4/5/2020
 *
 * @author argen
 */
public class LaraCroft {

    public static final String NAME = "Lara Croft";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.TOXIC, 1.2);

        FighterStats stats = FighterStats.builder().strength(5).toughness(5.5).dexterity(6.5).aim(8)
                .agility(5.5).speed(4.5).intellect(6).willpower(5.5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A weaponmaster with guns unhindered by the need for ammo.")
                .entryQuotes(Arrays.asList("Lara: 'Get out of the way, or you die.'",
                        "Lara: 'You have my total attention now.'"))
                .victoryQuotes(Arrays.asList("Lara: 'I'm afraid you've been mistaken. I only play for sport.'",
                        "Lara: 'Don't you think you've seen enough?'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new DualPistols()).addAction(new DualUzis()).addAction(new ClimbingAxe())
                .addAction(new CompoundBow())
                .addAction(new ReforgedExcalibur())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
