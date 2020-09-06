package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 4/1/2020
 *
 * @author argen
 */
public class Rathalos {

    public static final String NAME = "Rathalos";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 0.6);
        defenses.set(AttackSubType.WATER, 1.2);
        defenses.set(AttackSubType.THUNDER, 1.4);
        defenses.set(AttackSubType.ICE, 1.2);
        defenses.set(AttackSubType.TOXIC, 1.2);
        defenses.set(AttackSubType.AIR, 1.2);
        defenses.set(AttackSubType.EXPLOSIVE, 1.2);
        defenses.set(AttackSubType.SOUND, 0.6);

        FighterStats stats = FighterStats.builder().strength(9).toughness(2).dexterity(4.5).aim(5)
                .agility(4).speed(3).intellect(1.5).willpower(6).size(9.5).weight(8.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(200).maxHp(200).xStrikeMeter(0)
                .description("A large tank with a variety of exploitable weaknesses.")
                .entryQuotes(Arrays.asList("The Rathalos soars through the sky and lands on the battlefield.",
                        "The Rathalos roars in a terrifying manner at his opponent.'"))
                .victoryQuotes(Arrays.asList("The Rathalos rears back and roars triumphantly.",
                        "The Rathalos flies off, having dealt with the immediate threat."))
                .classifications(Arrays.asList(FighterClassification.MONSTER, FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new WyvernFireball()).addAction(new SonicRoar()).addAction(new PoisonClaw())
                .addAction(new SlidingTackle())
                .addAction(new ExplosiveFireballs())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
