package com.argentstew.simulator.battle.vg.amaterasu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DemonSlayer;
import com.argentstew.simulator.battle.trait.impl.Sunrise;
import com.argentstew.simulator.battle.trait.impl.TimeManipulation;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.amaterasu
 * 3/26/2020
 *
 * @author argen
 */
public class Amaterasu {

    public static final String NAME = "Amaterasu";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.DARK, 0.8);
        defenses.set(AttackSubType.FIRE, 0.8);
        defenses.set(AttackSubType.WATER, 1.2);
        defenses.set(AttackSubType.GRAVITY, 0.9);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(4).dexterity(9.5).aim(6)
                .agility(8).speed(7).intellect(8).willpower(7).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new DemonSlayer(), new TimeManipulation(), new Sunrise()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter who punishes enemies relying on the power of darkness.")
                .entryQuotes(Arrays.asList("Issun: 'Let's have one of those famous howls of yours!'",
                        "Issun: 'Whoa, whoa, whoa, Ammy!'"))
                .victoryQuotes(Arrays.asList("Issun: 'Good job, Ammy! I knew you could do it! Let's get back to Kamiki Village!'",
                        "Issun: 'If you pray with all your heart, maybe the sun will cheer up and show itself once again.'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new HeadCharge()).addAction(new CherryBomb()).addAction(new PowerSlash())
                .addAction(new ColdStar()).addAction(new SolarFlare())
                .addAction(new DivineInstruments())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
