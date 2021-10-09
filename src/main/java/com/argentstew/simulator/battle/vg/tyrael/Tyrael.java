package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Righteousness;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.trait.impl.Teleportation;
import com.argentstew.simulator.battle.vg.diablo.Diablo;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 4/5/2020
 *
 * @author argen
 */
public class Tyrael {

    public static final String NAME = "Tyrael";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.75);
        defenses.set(AttackSubType.KICK, 0.75);
        defenses.set(AttackSubType.HEADBUTT, 0.7);
        defenses.set(AttackSubType.CLAW, 0.8);
        defenses.set(AttackSubType.BITE, 0.8);
        defenses.set(AttackSubType.TAIL, 0.8);
        defenses.set(AttackSubType.WING, 0.8);
        defenses.set(AttackSubType.SLASH, 0.75);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 1.4);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);
        defenses.set(AttackSubType.DARK, 0.75);
        defenses.set(AttackSubType.GRAVITY, 1.15);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(9).dexterity(4.5).aim(3)
                .agility(2).speed(2.5).intellect(7).willpower(8).size(5.5).weight(6.5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new Righteousness(), new Teleportation(), new Rival(Diablo.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(175).maxHp(175).mp(0).xStrikeMeter(0)
                .description("An armored tank that can deal light damage with every attack.")
                .entryQuotes(Arrays.asList("Tyrael: 'Reckoning is at hand.'",
                        "Tyrael: 'You cannot judge me; I am Justice itself!'"))
                .victoryQuotes(Arrays.asList("Tyrael: 'So it is done...'",
                        "Tyrael: 'May the Light protect you and the powers of Heaven shine upon your path...'"))
                .classifications(Collections.singletonList(FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new Eldruin()).addAction(new DivineReckoning()).addAction(new Smite())
                .addAction(new ArchangelsWrath()).addAction(new Sanctification())
                .addAction(new ArchangelsJudgment())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
