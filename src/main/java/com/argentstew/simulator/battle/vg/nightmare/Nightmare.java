package com.argentstew.simulator.battle.vg.nightmare;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;
import com.argentstew.simulator.battle.trait.impl.StanceChange;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nightmare
 * 9/7/2019
 *
 * @author Craig
 */
public class Nightmare {

    public static final String NAME = "Nightmare";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.CLAW, 0.8);
        defenses.set(AttackSubType.BITE, 0.8);
        defenses.set(AttackSubType.TAIL, 0.8);
        defenses.set(AttackSubType.WING, 0.8);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 1.3);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);
        defenses.set(AttackSubType.GRAVITY, 1.1);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7.5).dexterity(4).aim(4)
                .agility(3.5).speed(3.5).intellect(7).willpower(4).size(5).weight(6).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new StanceChange(), new ComboStrike()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("An armored brawler who can change stances to adjust speed and damage.")
                .entryQuotes(Arrays.asList("Nightmare: 'Show me the madness that hides within!'",
                        "Nightmare: 'Offer your soul!'"))
                .victoryQuotes(Arrays.asList("Nightmare: 'There will be no order as long Soul Edge and those abominations, the malfested, exist.'",
                        "Nightmare: 'Souls. Give me more souls!'"))
                .classifications(Collections.singletonList(FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new SoulEdge()).addAction(new SoulWave()).addAction(new DarksideKick())
                .addAction(new EarthTrample()).addAction(new UnholyTerror())
                .addAction(new DireVengeance())
                .addAction(new DarkReconquista())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
