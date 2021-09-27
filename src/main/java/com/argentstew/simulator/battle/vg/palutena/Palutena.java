package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 4/5/2020
 *
 * @author argen
 */
public class Palutena {

    public static final String NAME = "Palutena";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.GRAVITY, 0.95);
        defenses.set(AttackSubType.DARK, 1.4);

        FighterStats stats = FighterStats.builder().strength(4).toughness(3).dexterity(6).aim(6)
                .agility(6.5).speed(6.5).intellect(7.5).willpower(4).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Teleportation()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(0).maxMp(36).xStrikeMeter(0)
                .description("An all-around fighter that can only carry a portion of her large moveset into battle.")
                .entryQuotes(Arrays.asList("Palutena: 'You shall be purified!'",
                        "Palutena: 'Uh... this really doesn't look like much of a party.'"))
                .victoryQuotes(Arrays.asList("Palutena: 'No one can hide from the light!'",
                        "Palutena: 'As the goddess of light, it's my duty to protect humanity!'"))
                .classifications(Collections.singletonList(FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Autoreticle()).addAction(new WeakpointReticle()).addAction(new AngelicMissile())
                .addAction(new ExplosiveFlame()).addAction(new BlackHole()).addAction(new MeteorShower())
                .addAction(new HeavenlyLight()).addAction(new PoisonAttack()).addAction(new ParalyzeAttack())
                .addAction(new BurnAttack()).addAction(new FreezeAttack())
                .addAction(new ReflectBarrier()).addAction(new BriefInvincibility()).addAction(new HealthRecovery())
                .addAction(new MegaLaser())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
