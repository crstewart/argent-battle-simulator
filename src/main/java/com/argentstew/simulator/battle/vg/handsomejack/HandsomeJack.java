package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.terry.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 4/4/2020
 *
 * @author argen
 */
public class HandsomeJack {

    public static final String NAME = "Handsome Jack";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.FIRE, 1.1);

        FighterStats stats = FighterStats.builder().strength(3.5).toughness(3).dexterity(7).aim(7.5)
                .agility(4).speed(4).intellect(7).willpower(7).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("An antagonistic weaponmaster who has attacks that target specific fighter classes.")
                .entryQuotes(Arrays.asList("Handsome Jack: '\"Too many people die.\" Give me a break!'",
                        "Handsome Jack: 'There's nowhere to hide now, sucker!'"))
                .victoryQuotes(Arrays.asList("Handsome Jack: 'It's cute that you think you're the hero of this little adventure, but, you're NOT.'",
                        "Handsome Jack: 'I'm gonna kill you and the rest of your stupid friends!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new EnergyBolt()).addAction(new IncendiaryBeam()).addAction(new CorrosiveGrenade())
                .addAction(new Turret()).addAction(new ShieldSurveyor())
                .addAction(new SummonTheWarrior())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
