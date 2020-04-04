package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.heihachi.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 4/3/2020
 *
 * @author argen
 */
public class KOSMOS {

    public static final String NAME = "KOS-MOS";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.NATURE, 0.95);
        defenses.set(AttackSubType.HANDGUN, 0.9);
        defenses.set(AttackSubType.RIFLE, 0.9);
        defenses.set(AttackSubType.SHOTGUN, 0.9);

        FighterStats stats = FighterStats.builder().strength(8.5).toughness(8).dexterity(4.5).aim(5)
                .agility(3).speed(3.5).intellect(7).willpower(1.5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A futuristic brawler with a mix or melee and ranged attacks at her disposal.")
                .entryQuotes(Arrays.asList("KOS-MOS: 'Target locked on. Commencing combat mode.'",
                        "KOS-MOS: 'All battle systems are go.'"))
                .victoryQuotes(Arrays.asList("KOS-MOS: 'Shutting down. Requesting recovery of HP.'",
                        "KOS-MOS: 'I am happy... to be of service.'"))
                .classifications(Collections.singletonList(FighterClassification.MECH))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new FScythe()).addAction(new FGShot()).addAction(new RBlade())
                .addAction(new RCannon())
                .addAction(new DTeneritas())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
