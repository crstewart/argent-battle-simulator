package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Trickster;
import com.argentstew.simulator.battle.vg.sans.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 4/8/2020
 *
 * @author argen
 */
public class Joker {

    public static final String NAME = "Joker";
    public static final String PERSONA_ARSENE = "Persona: Arsene";
    public static final String PERSONA_VISHNU = "Persona: Vishnu";
    public static final String PERSONA_FUTSUNUSHI = "Persona: Futsunushi";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(4).toughness(5).dexterity(7.5).aim(8)
                .agility(6.5).speed(5.5).intellect(6).willpower(5.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Trickster()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(0).maxMp(100).xStrikeMeter(0)
                .description("A speedy fighter who can summon personas to improve his power.")
                .entryQuotes(Arrays.asList("Joker: 'Leave it to me!'", "Joker: 'You're done!'"))
                .victoryQuotes(Arrays.asList("Joker: 'Well onto the next trial.'", "Joker: 'Checkmate.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new JokerStrategy()).build()
                .addAction(new Gun()).addAction(new Knife()).addAction(new RebelsGuard())
                .addAction(new SummonArsene()).addAction(new SummonVishnu()).addAction(new SummonFutsunushi())
                .addAction(new GunSpecial()).addAction(new Eigaon()).addAction(new Cleave())
                .addAction(new DreamNeedle()).addAction(new Megidolaon()).addAction(new VacuumWave())
                .addAction(new MyriadSlashes()).addAction(new BraveBlade()).addAction(new Regenerate())
                .addAction(new AllOutAttack())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
