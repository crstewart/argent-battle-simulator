package com.argentstew.simulator.battle.vg.ratchet;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.TimeManipulation;
import com.argentstew.simulator.battle.vg.jak.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ratchet
 * 4/2/2020
 *
 * @author argen
 */
public class RatchetAndClank {

    public static final String NAME = "Ratchet & Clank";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.4);
        defenses.set(AttackSubType.ASSIST, 0.6);

        FighterStats stats = FighterStats.builder().strength(4).toughness(4).dexterity(6).aim(8.5)
                .agility(5.5).speed(4.5).intellect(7).willpower(5).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new TimeManipulation()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A futuristic weaponmaster duo who wields a large arsenal of guns.")
                .entryQuotes(Arrays.asList("Ratchet: 'Slow down. Don't embarrass yourself.'",
                        "Clank: 'Why you... you...'"))
                .victoryQuotes(Arrays.asList("Ratchet: 'I can barely breathe, and my tail feels like its shoved right up my...'",
                        "Clank: 'Why must we always choose between certain death and probable death?'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new IonBlaster()).addAction(new Omniwrench()).addAction(new TeslaClaw())
                .addAction(new Combuster()).addAction(new FusionGrenade()).addAction(new VortexCannon())
                .addAction(new TeslaBarrier())
                .addAction(new RynoV())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
